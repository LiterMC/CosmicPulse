package com.github.litermc.cosmicpluse.api.laser;

public enum LaserEmitterType {
	/**
	 * Emit from a block
	 */
	BLOCK,
	/**
	 * Emit from an entity
	 */
	ENTITY,
	/**
	 * Relayed through a portal or such.
	 */
	INTERMEDIATE;
}
