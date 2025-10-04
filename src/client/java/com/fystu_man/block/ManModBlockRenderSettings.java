package com.fystu_man.block;

import com.fystu_man.Man;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.client.render.RenderLayer;

import java.util.Map;

public class ManModBlockRenderSettings {

    public static void init() {
        Man.LOGGER.info("Setting ManModBlock Render...");
        set();
        Man.LOGGER.info("ManModBlock Render Setting Done!");
    }

    private static void set() {
        set(ManModBlocks.TEA_TREE, RenderLayer.getCutout());
    }

    private static void set(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
