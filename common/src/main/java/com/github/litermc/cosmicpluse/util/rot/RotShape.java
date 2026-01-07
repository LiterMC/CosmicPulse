/**
 * Copyright 2023  The authors of VS tournament
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
