package com.github.litermc.cosmicpluse.api.laser;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public interface ILaserAttachment {
	/**
	 * canPassThroughBlock will be invoked when a laser passing a block.
	 * You can invoke {@link LaserContext#cancel} to immediately cancel further processing.
	 *
	 * @param ctx   The {@link LaserContext}
	 * @param state The {@link BlockState} of the hitting block
	 * @param level The level of the hitting block
	 * @param pos   The position of the hitting block
	 * @return {@link Boolean#TRUE} if the block is passable,
	 *     {@link Boolean#FALSE} if the block is not passable,
	 *     or {@code null} if unknown, which will invoke next checker.
	 *
	 * @see LaserContext.cancel
	 */
	default Boolean canPassThroughBlock(LaserContext ctx, BlockState state, BlockGetter level, BlockPos pos) {
		return null;
	}

	/**
	 * beforeProcessLaser will be invoked before the laser is going to process a block.
	 * You can invoke {@link LaserContext#cancel} to cancel further processing,
	 * and {@link LaserContext#getHitResult} will return the HitResult.
	 *
	 * @param ctx       The {@link LaserContext}
	 * @param state     The {@link BlockState} of the hitting block
	 * @param pos       The position of the hitting block
	 * @param processor The processor, will never be {@code null}
	 *
	 * @see afterProcessLaser
	 * @see LaserContext.cancel
	 * @see LaserContext.getHitResult
	 * @see ILaserProcessor.isEndPoint
	 */
	default void beforeProcessLaser(LaserContext ctx, BlockState state, BlockPos pos, ILaserProcessor processor) {}

	/**
	 * afterProcessLaser will be invoked after the laser processed a block.
	 *
	 * @param ctx      The {@link LaserContext}
	 * @param oldState The block's {@link BlockState} before laser processed
	 * @param pos      The block's position
	 *
	 * @see beforeProcessLaser
	 */
	default void afterProcessLaser(LaserContext ctx, BlockState oldState, BlockPos pos) {}

	/**
	 * beforeMergeLaser will be invoked before the attached laser is merging to another.
	 * After this method is invoked, the attachment will never be use again on the original context.
	 * You can invoke {@link LaserContext#cancel} to cancel the merge and further processing on the laser.
	 *
	 * @param ctx    The attached {@link LaserContext}
	 * @param target The {@link LaserContext} which going to be merge to
	 *
	 * @see afterMergeLaser
	 * @see LaserContext.cancel
	 */
	default void beforeMergeLaser(LaserContext ctx, LaserContext target) {}

	/**
	 * afterMergeLaser will be invoked after the attached laser is merged to another.
	 * If needed, attachment can attach itself to the target laser in this method.
	 *
	 * @param ctx    The attached {@link LaserContext}
	 * @param target The {@link LaserContext} which being merged to
	 * @param props  The target laser's {@link LaserProperties}
	 *
	 * @see beforeMergeLaser
	 */
	default void afterMergeLaser(LaserContext ctx, LaserContext target, LaserProperties props) {}
}
