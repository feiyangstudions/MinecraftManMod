package com.fystu_man;

import com.fystu_man.item.ManModItems;
import com.fystu_man.sound.ManModSoundEvents;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Man implements ModInitializer {
	public static final String MOD_ID = "fystu_man";
	public static final String MOD_NAME = "FYSTU Man Mod";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ManModSoundEvents.initialize();

		ManModItems.registerModItems();
		LOGGER.info("Minecraft Man Mod Load Done!");
	}
}