package com.github.litermc.cosmicpluse.util.rot;

import net.minecraft.world.phys.shapes.VoxelShape;

/*
 * This code has been translated from kotlin and used from the Tournament source code
 * https://github.com/alex-s168/VS_tournament_continued/blob/main/common/src/main/kotlin/org/valkyrienskies/tournament/util/RotShapes.kt
 * 
 * All credit goes to Constantdust
 */
public interface RotShape {
	RotShape rotate90();
	
	default RotShape rotate180() {
		return rotate90().rotate90();
	}
	
	default RotShape rotate270() {
		return rotate180().rotate90();
	}

	RotShape xrotate90();

	default RotShape xrotate180() {
		return xrotate90().xrotate90();
	}

	default RotShape xrotate270() {
		return xrotate180().xrotate90();
	}

	VoxelShape makeMcShape();
	default VoxelShape build() {
		return makeMcShape().optimize();
	}
}
