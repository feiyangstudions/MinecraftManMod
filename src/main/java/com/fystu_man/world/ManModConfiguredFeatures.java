package com.fystu_man.world;

import com.fystu_man.Man;
import com.fystu_man.block.ManModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;

public class ManModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> TEA_TREE_KEY = of("tree_tree");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        register(featureRegisterable, TEA_TREE_KEY, Feature.FLOWER, new RandomPatchFeatureConfig(16, 5, 2,
                PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(
                        ManModBlocks.TEA_TREE
                )))));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> of(String id)
    {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Man.MOD_ID, id));
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> void register(
            Registerable<ConfiguredFeature<?, ?>> registerable, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC featureConfig
    ) {
        registerable.register(key, new ConfiguredFeature<FC, F>(feature, featureConfig));
    }
}
