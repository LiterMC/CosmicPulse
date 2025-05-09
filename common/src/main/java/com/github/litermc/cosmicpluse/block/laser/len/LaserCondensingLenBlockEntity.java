package com.github.litermc.cosmicpluse.block.laser.len;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import org.joml.Vector3d;
import org.valkyrienskies.core.api.ships.Ship;
import org.valkyrienskies.mod.common.VSGameUtilsKt;

import com.github.litermc.cosmicpluse.api.laser.ILaserAttachment;
import com.github.litermc.cosmicpluse.api.laser.LaserContext;
import com.github.litermc.cosmicpluse.api.laser.LaserEmitter;
import com.github.litermc.cosmicpluse.api.laser.LaserProperties;
import com.github.litermc.cosmicpluse.api.laser.LaserUtil;
import com.github.litermc.cosmicpluse.block.VSCHBlockEntities;

public class LaserCondensingLenBlockEntity extends AbstractDirectionalLaserLenBlockEntity {
	private LaserContext merging = null;

	public LaserCondensingLenBlockEntity(BlockPos pos, BlockState state) {
		super(VSCHBlockEntities.LASER_CONDENSING_LEN_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public int getMaxLaserStrengthPerTick() {
		return 256 * 16;
	}

	@Override
	public void onLaserHit(final LaserContext ctx) {
		super.onLaserHit(ctx);
		final Direction facing = this.getFacing();
		final BlockHitResult hitResult = (BlockHitResult) (ctx.getHitResult());
		final LaserProperties props = ctx.getLaserOnHitProperties();
		final Vec3 hitPos = hitResult.getLocation();
		final Vec3 inputDir = ctx.getInputDirection();
		if (hitResult.getDirection() == facing) {
			if (this.merging == null) {
				this.merging = ctx.redirectWith(
					props,
					LaserEmitter.fromBlockEntityCenter(this, Vec3.atLowerCornerOf(facing.getOpposite().getNormal()))
				);
				return;
			}
			LaserUtil.mergeLaser(ctx, this.merging);
			return;
		}
		if (hitResult.getDirection() != facing.getOpposite()) {
			return;
		}
		LaserUtil.fireRedirectedLaser(
			ctx.redirectWith(
				props.afterLoss(0.5),
				LaserEmitter.fromBlockEntity(this, hitPos, inputDir)
			)
		);
	}

	@Override
	public void tickForce(ServerLevel level, BlockPos pos, BlockState state) {
		super.tickForce(level, pos, state);
		final LaserContext firing = this.merging;
		if (firing == null) {
			return;
		}
		this.merging = null;
		LaserUtil.fireRedirectedLaser(firing);
	}
}
