package com.fystu_man.block;

import com.fystu_man.Man;
import com.fystu_man.block.custom.TeaTreeBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ManModBlocks {
    public static final Block TEA_TREE = register(
            "tea_tree",
            new TeaTreeBlock(
                    StatusEffects.SPEED,
                    12,
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.DARK_GREEN)
                            .nonOpaque()
                            .noCollision()
                            .strength(0.1F)
                            .sounds(BlockSoundGroup.CHERRY_LEAVES)
            ));

    private static void registerBlockItem(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(Man.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem)item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    private static Block register(String id, Block block) {
        registerBlockItem(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Man.MOD_ID, id), block);
    }

    public static void registerModBlocks() {
        Man.LOGGER.info("Registering Mod Blocks");
    }

}
