package com.fystu_man.item;

import com.fystu_man.Man;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ManModItemGroups {
    public static final RegistryKey<ItemGroup> MAN = register("man");

    public static RegistryKey<ItemGroup> register(String id) {
        return RegistryKey.of(RegistryKeys.ITEM_GROUP, Identifier.of(Man.MOD_ID, id));
    }

    public static void registerModItems() {
        Man.LOGGER.info("Registering Mod ItemGroups");
        Registry.register(
                Registries.ITEM_GROUP,
                MAN,
                ItemGroup.create(ItemGroup.Row.TOP, 7)
                        .displayName(Text.translatable("itemGroup.man"))
                        .icon(() -> new ItemStack(ManModItems.ICE_TEA))
                        .entries((displayContext, entries) -> {
                            entries.add(ManModItems.ICE_TEA);
                            entries.add(ManModItems._24BS);
                            entries.add(ManModItems.SEE_YOU_AGAIN);
                            entries.add(ManModItems.AWAKENED_ICE_TEA);
                        })
                        .build()
        );
    }
}
