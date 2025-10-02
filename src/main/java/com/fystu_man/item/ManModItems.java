package com.fystu_man.item;

import com.fystu_man.Man;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ManModItems {
    public static final Item ICE_TEA = register("ice_tea", new Item(new Item.Settings()));
    public static final Item _24BS = register("24bs", new Item(new Item.Settings()));
    public static final Item SEE_YOU_AGAIN = register("see_you_again", new Item(new Item.Settings()));

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Man.MOD_ID, id), item);
    }

    public static void registerModItems() {
        Man.LOGGER.info("Registering Mod Items");
        Man.LOGGER.info("Adding Items To Item Group");
        ManModItemGroups.registerModItems();
    }
}
