package com.fystu_man.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ManModFoodComponents {
    public static final FoodComponent.Builder TEA_B = registry(3, 1.0F, true, new StatusEffectInstance[] {
            new StatusEffectInstance(StatusEffects.SPEED, 2400, 2)
    }, new float[] {1.0F});
    public static final FoodComponent.Builder ICE_TEA_B = registry(8, 1.5F, true ,new StatusEffectInstance[] {
            new StatusEffectInstance(StatusEffects.SPEED, 2400, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0),
            new StatusEffectInstance(StatusEffects.HASTE, 2400, 3)
    }, new float[] {1.0F, 1.0F, 0.9F});

    private static FoodComponent.Builder registry(int nutrition, float saturation, boolean alwaysEdible)
    {
        return registry(nutrition, saturation, alwaysEdible, null, null);
    }

    private static FoodComponent.Builder registry(int nutrition, float saturation, boolean alwaysEdible, StatusEffectInstance[] effect, float[] effectChance) {
        FoodComponent.Builder fcb = new FoodComponent.Builder()
                .nutrition(nutrition)
                .saturationModifier(saturation);
        if (alwaysEdible) fcb.alwaysEdible();
        if (effect == null || effect.length == 0
            || effectChance == null || effectChance.length == 0
            || effect.length != effectChance.length)
            return fcb;
        for(int i = 0; i < effect.length; i++) {
            fcb.statusEffect(effect[i], effectChance[i]);
        }

        return fcb;
    }
}
