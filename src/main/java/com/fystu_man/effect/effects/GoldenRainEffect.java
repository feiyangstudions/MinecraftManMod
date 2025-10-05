package com.fystu_man.effect.effects;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.Random;

public class GoldenRainEffect extends StatusEffect {

    public GoldenRainEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xF0C043);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 10 == 0;
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        World world = entity.getWorld();
        if (!world.isClient && entity instanceof PlayerEntity player) {

            ItemStack goldIngot = new ItemStack(Items.GOLD_INGOT);
            Random rand = new Random();
            double spawnX = player.getX() + rand.nextInt(-4, 4);
            // Player Y + Player Height + 3.5 = Above Player's Head 3.5 Block High
            double spawnY = player.getY() + player.getHeight() + 3.5;
            double spawnZ = player.getZ() + rand.nextInt(-4, 4);
            ItemEntity goldIngotEntity = new ItemEntity(
                    world,
                    spawnX,
                    spawnY,
                    spawnZ,
                    goldIngot
            );
            goldIngotEntity.setVelocity(0, 0.1, 0);
            goldIngotEntity.setPickupDelay(0);

            world.spawnEntity(goldIngotEntity);
            world.playSound(
                    null,
                    spawnX,
                    spawnY,
                    spawnZ,
                    SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP,
                    SoundCategory.PLAYERS,
                    0.75F,
                    1.0F
            );
            if (world instanceof ServerWorld serverWorld)
                serverWorld.spawnParticles(
                        ParticleTypes.OMINOUS_SPAWNING,
                        spawnX, spawnY, spawnZ,
                        50,
                        1.5, 1.5, 1.5,
                        0.2
                );
        }

        return true;
    }
}
