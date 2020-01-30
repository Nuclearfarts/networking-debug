package io.github.nuclearfarts.packeterrorlogger;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.network.packet.SynchronizeRecipesS2CPacket;

public class Initializer implements ModInitializer {
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//System.out.println(SynchronizeRecipesS2CPacket.class);
	}
}
