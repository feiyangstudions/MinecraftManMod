package com.fystu_man;

import com.fystu_man.sound.ManModJukeboxSongs;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class ManModDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        Man.LOGGER.info("Initializing Data Generator");
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.JUKEBOX_SONG, ManModJukeboxSongs::bootstrap);
    }
}
