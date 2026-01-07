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

import net.minecraft.core.Direction;
import net.minecraft.world.phys.shapes.VoxelShape;

/*
 * This code has been translated from kotlin and used from the Tournament source code
 * https://github.com/alex-s168/VS_tournament_continued/blob/main/common/src/main/kotlin/org/valkyrienskies/tournament/util/RotShapes.kt
 * 
 * All credit goes to Constantdust (who Alex tells me wrote this section of tournament)
 */
public class DirectionalShape {
	private final VoxelShape north;
	private final VoxelShape east;
	private final VoxelShape south;
	private final VoxelShape west;
	private final VoxelShape up;
	private final VoxelShape down;

	private DirectionalShape(RotShape shape) {
		this.north = shape.build();
		this.east = shape.rotate90().build();
		this.south = shape.rotate180().build();
		this.west = shape.rotate270().build();
		this.up = shape.xrotate90().build();
		this.down = shape.xrotate270().build();
	}

	public VoxelShape get(Direction direction) {
		return switch (direction) {
			case NORTH -> this.north;
			case EAST -> this.east;
			case SOUTH -> this.south;
			case WEST -> this.west;
			case UP -> this.up;
			case DOWN -> this.down;
		};
	}

	public static DirectionalShape north(RotShape shape) {
		return new DirectionalShape(shape);
	}

	public static DirectionalShape east(RotShape shape) {
		return new DirectionalShape(shape.rotate270());
	}

	public static DirectionalShape south(RotShape shape) {
		return new DirectionalShape(shape.rotate180());
	}

	public static DirectionalShape west(RotShape shape) {
		return new DirectionalShape(shape.rotate90());
	}

	public static DirectionalShape up(RotShape shape) {
		return new DirectionalShape(shape.xrotate270());
	}

	public static DirectionalShape down(RotShape shape) {
		return new DirectionalShape(shape.xrotate90());
	}
}
