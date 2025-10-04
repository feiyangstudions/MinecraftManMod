package com.fystu_man;

import com.fystu_man.block.ManModBlockRenderSettings;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ManClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(Man.MOD_NAME + " Client");

	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ManModBlockRenderSettings.initialize();

		LOGGER.info("Minecraft Man Mod Client Load Done!");
	}
}