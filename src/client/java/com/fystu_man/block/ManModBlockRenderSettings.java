package com.fystu_man.block;

import com.fystu_man.Man;
import com.fystu_man.ManClient;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;

public class ManModBlockRenderSettings {

    public static void initialize() {
        ManClient.LOGGER.info("Setting ManModBlock Render...");
        set();
        ManClient.LOGGER.info("ManModBlock Render Setting Done!");
    }

    private static void set() {
        set(ManModBlocks.TEA_TREE, RenderLayer.getCutout());
    }

    private static void set(Block block, RenderLayer layer) {
        BlockRenderLayerMap.INSTANCE.putBlock(block, layer);
    }
}
