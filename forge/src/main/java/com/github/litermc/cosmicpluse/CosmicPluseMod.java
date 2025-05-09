package com.github.litermc.cosmicpluse;

import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.github.litermc.cosmicpluse.api.laser.LaserUtil;

@Mod(Constants.MOD_ID)
public class CosmicPluseMod {
	public CosmicPluseMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		modBus.addListener(this::onClientSetup);
		modBus.addListener(this::onServerTick);
	}

	private void onClientSetup(final FMLClientSetupEvent event) {
	}

	private void onServerTick(final TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			LaserUtil.afterServerTick();
		}
	}
}
