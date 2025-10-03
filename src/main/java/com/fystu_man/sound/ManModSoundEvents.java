package com.fystu_man.sound;

import com.fystu_man.Man;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ManModSoundEvents {
    public static final RegistryEntry.Reference<SoundEvent> SEE_YOU_AGAIN_S = registerReference("music_disc.see_you_again");

    private static RegistryEntry.Reference<SoundEvent> registerReference(String name)
    {
        Identifier id = Identifier.of(Man.MOD_ID, name);
        return Registry.registerReference(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void initialize() {
        Man.LOGGER.info("Initializing ManModSoundEvents");
    }
}
