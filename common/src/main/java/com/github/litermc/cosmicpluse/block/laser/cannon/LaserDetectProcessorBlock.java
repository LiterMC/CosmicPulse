package com.github.litermc.cosmicpluse.block.laser.cannon;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import com.github.litermc.cosmicpluse.block.laser.cannon.LaserDetectProcessorBlockEntity;

public class LaserDetectProcessorBlock extends LaserCannonBlock<LaserDetectProcessorBlockEntity> {
	public LaserDetectProcessorBlock(BlockBehaviour.Properties properties) {
		super(properties, LaserDetectProcessorBlockEntity::new);
	}

	@Override
	public int getAnalogOutputSignal(BlockState state, Level level, BlockPos pos) {
		return level.getBlockEntity(pos) instanceof LaserDetectProcessorBlockEntity be ? be.getAnalogOutput() : 0;
	}
}
