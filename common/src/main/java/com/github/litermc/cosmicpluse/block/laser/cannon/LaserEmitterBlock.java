package com.github.litermc.cosmicpluse.block.laser.cannon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import com.github.litermc.cosmicpluse.block.laser.cannon.LaserEmitterBlockEntity;
import com.github.litermc.cosmicpluse.block.template.IColoredBlockEntity;

public class LaserEmitterBlock extends LaserCannonBlock<LaserEmitterBlockEntity> {
	public LaserEmitterBlock(BlockBehaviour.Properties properties) {
		super(properties, LaserEmitterBlockEntity::new);
	}

	@Override
	public InteractionResult use(
			BlockState state, Level level, BlockPos pos,
			Player player, InteractionHand hand,
			BlockHitResult hit
	) {
		return IColoredBlockEntity.onUse(state, level, pos, player, hand, hit, true);
	}
}
