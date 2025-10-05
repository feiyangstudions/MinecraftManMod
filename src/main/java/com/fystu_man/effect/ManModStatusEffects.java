package com.fystu_man.effect;

import com.fystu_man.Man;
import com.fystu_man.effect.effects.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ManModStatusEffects {
    public static final RegistryEntry<StatusEffect> GOLDEN_RAIN =
            register("golden_rain", new GoldenRainEffect());
    public static final RegistryEntry<StatusEffect> GOLDEN_TOUCH =
            register("golden_touch", new GoldenTouchEffect());

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect effect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Man.MOD_ID, id), effect);
    }

    public static void initialize() {
        Man.LOGGER.info("Initializing ManModStatusEffects");
        GoldenTouchEffect.initializeEvent();
    }
}
