package com.fystu_man.item.custom;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class DrinkableItem extends Item {

    public DrinkableItem(Settings settings) {
        super(settings);
    }

    @Override
    public SoundEvent getEatSound() {
        return super.getDrinkSound();
    }
}
