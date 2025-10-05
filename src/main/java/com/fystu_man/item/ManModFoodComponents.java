package com.fystu_man.item;

import com.fystu_man.effect.ManModStatusEffects;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ManModFoodComponents {
    public static final FoodComponent.Builder TEA_LEAVES_B = registry(1, 0.1F, false);
    public static final FoodComponent.Builder TEA_B = registry(3, 1.0F, true, new StatusEffectInstance[] {
            new StatusEffectInstance(StatusEffects.SPEED, 2400, 2)
    }, new float[] {1.0F});
    public static final FoodComponent.Builder ICE_TEA_B = registry(8, 1.5F, true ,new StatusEffectInstance[] {
            new StatusEffectInstance(StatusEffects.SPEED, 2400, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0),
            new StatusEffectInstance(StatusEffects.HASTE, 2400, 3)
    }, new float[] {1.0F, 1.0F, 0.9F});
    public static final FoodComponent.Builder NETHER_STAR_TEA_B = registry(10, 2.0F, true, new StatusEffectInstance[] {
            new StatusEffectInstance(StatusEffects.SPEED, 2400, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0),
            new StatusEffectInstance(StatusEffects.HASTE, 2400, 3),
            new StatusEffectInstance(StatusEffects.RESISTANCE, 600, 1),
            new StatusEffectInstance(StatusEffects.NIGHT_VISION, 6000, 0),
            new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 4)
    }, new float[] {1.0F, 1.0F, 1.0F, 0.8F, 1.0F, 0.9F});
    public static final FoodComponent.Builder NETHER_STAR_ICE_TEA_B = registry(10, 2.0F, true, new StatusEffectInstance[] {
            new StatusEffectInstance(StatusEffects.SPEED, 4800, 2),
            new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 2400, 0),
            new StatusEffectInstance(StatusEffects.HASTE, 4800, 3),
            new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 1),
            new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 0),
            new StatusEffectInstance(StatusEffects.ABSORPTION, 9600, 4),
            new StatusEffectInstance(StatusEffects.STRENGTH, 4800, 11),
    }, new float[] {1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F, 1.0F});
    public static final FoodComponent.Builder GOLDEN_TEA = registry(2, 1.0F, true, new StatusEffectInstance[] {
            new StatusEffectInstance(ManModStatusEffects.GOLDEN_RAIN, 600, 0),
            new StatusEffectInstance(StatusEffects.NIGHT_VISION, 4800, 0)
    }, new float[] {1.0F, 1.0F});
    public static final FoodComponent.Builder GOLDEN_ICE_TEA = registry(5, 1.0F, true, new StatusEffectInstance[] {
            new StatusEffectInstance(ManModStatusEffects.GOLDEN_TOUCH, 400, 0),
            new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 0)
    }, new float[] {0.9F, 1.0F});

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
