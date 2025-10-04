package com.fystu_man.item.custom;

import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvent;

public class DrinkableItem extends Item {

    public DrinkableItem(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getEatSound() {
        return super.getDrinkSound();
    }
}
