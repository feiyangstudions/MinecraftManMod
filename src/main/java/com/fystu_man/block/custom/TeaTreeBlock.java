package com.fystu_man.block.custom;

import com.fystu_man.item.ManModItems;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.component.type.SuspiciousStewEffectsComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class TeaTreeBlock extends FlowerBlock {
    public static final BooleanProperty HAS_LEAVE = BooleanProperty.of("has_leave");
    private static final int MIN_LIGHT_LEVEL = 8;

    public TeaTreeBlock(RegistryEntry<StatusEffect> stewEffect, float effectLengthInSeconds, AbstractBlock.Settings settings) {
        super(createStewEffectList(stewEffect, effectLengthInSeconds), settings.ticksRandomly());
        this.setDefaultState(this.getDefaultState().with(HAS_LEAVE, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HAS_LEAVE);
    }

    public void setHasLeave(World world, BlockPos pos, BlockState state, boolean hasLeave) {
        world.setBlockState(pos, state.with(HAS_LEAVE, hasLeave));
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        super.randomTick(state, world, pos, random);

        if (!getHasLeave(world, pos) && random.nextFloat() <= 0.1F && canGrow(world, pos)) {
            world.setBlockState(pos, state.with(HAS_LEAVE, true));
        }
    }

    private boolean canGrow(WorldView world, BlockPos pos) {
        // 检查光照
        int lightLevel = world.getLightLevel(pos);
        return lightLevel >= MIN_LIGHT_LEVEL;
    }

    public boolean getHasLeave(World world, BlockPos pos) {
        return world.getBlockState(pos).get(HAS_LEAVE);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        Hand hand = player.getActiveHand();
        if(getHasLeave(world, pos)) {
            if (world.isClient) return ActionResult.SUCCESS;

            world.setBlockState(pos, state.with(HAS_LEAVE, false));

            int dropCount = 5 + world.random.nextInt(2);
            ItemStack drop = new ItemStack(ManModItems.TEA_LEAVES, dropCount);

            ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), drop);
            world.playSound(null, pos, SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0F, 1.0F);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
