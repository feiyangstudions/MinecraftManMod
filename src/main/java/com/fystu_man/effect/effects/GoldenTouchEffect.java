package com.fystu_man.effect.effects;

import com.fystu_man.effect.ManModStatusEffects;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

import java.util.HashSet;
import java.util.Set;

public class GoldenTouchEffect extends StatusEffect {
    public GoldenTouchEffect() {
        super(StatusEffectCategory.BENEFICIAL, 0xF5AD3F);
    }

    public static final Set<Block> EXCLUDED_BLOCKS = new HashSet<>();
    static {
        // Creative Blocks
        EXCLUDED_BLOCKS.add(Blocks.BEDROCK);
        EXCLUDED_BLOCKS.add(Blocks.END_PORTAL_FRAME);
        EXCLUDED_BLOCKS.add(Blocks.END_PORTAL);
        EXCLUDED_BLOCKS.add(Blocks.NETHER_PORTAL);
        EXCLUDED_BLOCKS.add(Blocks.COMMAND_BLOCK);
        EXCLUDED_BLOCKS.add(Blocks.CHAIN_COMMAND_BLOCK);
        EXCLUDED_BLOCKS.add(Blocks.REPEATING_COMMAND_BLOCK);
        EXCLUDED_BLOCKS.add(Blocks.STRUCTURE_BLOCK);
        EXCLUDED_BLOCKS.add(Blocks.JIGSAW);
        EXCLUDED_BLOCKS.add(Blocks.BARRIER);
        EXCLUDED_BLOCKS.add(Blocks.SPAWNER);

        // Other Blocks
        EXCLUDED_BLOCKS.add(Blocks.DIAMOND_BLOCK);
        EXCLUDED_BLOCKS.add(Blocks.NETHERITE_BLOCK);
        EXCLUDED_BLOCKS.add(Blocks.FIRE);
    }

    public static void initializeEvent() {
        // Initialize Block Turn Event
        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (world.isClient || !player.hasStatusEffect(ManModStatusEffects.GOLDEN_TOUCH))
                return ActionResult.PASS;

            BlockState state = world.getBlockState(pos);
            Block block = state.getBlock();

            if (
                    EXCLUDED_BLOCKS.contains(block) ||
                            block == Blocks.GOLD_BLOCK ||
                            state.isAir()
            ) return ActionResult.PASS;

            world.setBlockState(pos, Blocks.GOLD_BLOCK.getDefaultState());
            world.playSound(
                    null, pos,
                    SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                    SoundCategory.BLOCKS,
                    1.0F, 1.0F
            );

            if (world instanceof ServerWorld serverWorld) {
                serverWorld.spawnParticles(
                        ParticleTypes.ENCHANT,
                        pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                        50,
                        1.5, 1.5, 1.5,
                        0.2
                );
            }

            return ActionResult.SUCCESS;
        });
    }
}
