package com.fystu_man.item;

import com.fystu_man.Man;
import com.fystu_man.sound.ManModJukeboxSongs;
import com.fystu_man.item.custom.*;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.UnbreakableComponent;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ManModItems {
    public static final Item ICE_TEA = register("ice_tea", new Item(createIS(1, null)));
    public static final Item _24BS = register("24bs", new _24BSItem(
            ManModArmorMaterials._24BS,
            ArmorItem.Type.CHESTPLATE,
            createIS(1, null)
                    .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true).withShowInTooltip(false))));
    public static final Item SEE_YOU_AGAIN = register("see_you_again", new Item(createIS(16, null)
            .rarity(Rarity.RARE).jukeboxPlayable(ManModJukeboxSongs.SEE_YOU_AGAIN_J)));
    public static final Item AWAKENED_ICE_TEA = register("awakened_ice_tea", new AwakenedIceTeaItem(
            ManModToolMaterials.ICE_TEA,
            createIS(1, Rarity.EPIC)
                    .attributeModifiers(SwordItem.createAttributeModifiers(
                            ManModToolMaterials.ICE_TEA, 0, -1F))
                    .component(DataComponentTypes.UNBREAKABLE, new UnbreakableComponent(true).withShowInTooltip(false))));

    private static Item register(String id, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Man.MOD_ID, id), item);
    }

    private static Item.Settings createIS(int maxCount, Rarity rarity)
    {
        Item.Settings is = new Item.Settings();
        if (maxCount > 0) {
            is.maxCount(maxCount);
        }
        if (rarity != null) {
            is.rarity(rarity);
        }

        return is;
    }

    public static void registerModItems() {
        Man.LOGGER.info("Registering Mod Items");
        Man.LOGGER.info("Adding Items To Item Group");
        ManModItemGroups.registerModItems();
    }
}
