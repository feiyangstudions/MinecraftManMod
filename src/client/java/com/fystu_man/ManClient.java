package com.fystu_man;

import com.fystu_man.block.ManModBlockRenderSettings;
import net.fabricmc.api.ClientModInitializer;

public class ManClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		ManModBlockRenderSettings.init();
	}
}