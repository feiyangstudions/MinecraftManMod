package com.fystu_man.item.custom;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class _24BSItem extends ArmorItem {

    public _24BSItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.fystu_man.24bs.line1"));
        tooltip.add(Text.translatable("tooltip.fystu_man.24bs.line2"));
        tooltip.add(Text.translatable("tooltip.fystu_man.24bs.line3"));
        tooltip.add(Text.translatable("tooltip.fystu_man.24bs.line4"));
        tooltip.add(Text.translatable("tooltip.fystu_man.24bs.line5"));
        tooltip.add(Text.translatable("tooltip.fystu_man.24bs.line6"));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
