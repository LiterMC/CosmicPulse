package com.github.litermc.cosmicpluse;

import com.github.litermc.cosmicpluse.api.laser.LaserUtil;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

public final class CosmicPluseListeners {
	private CosmicPluseListeners() {}

	public static void onModInit() {
		CosmicPluseRegistry.register();
	}

	public static void onServerLevelLoad(final ServerLevel level) {
	}

	public static void onServerLevelUnload(final ServerLevel level) {
	}

	public static void preServerTick(final MinecraftServer server) {
	}

	public static void postServerTick(final MinecraftServer server) {
		LaserUtil.postServerTick();
	}
}
