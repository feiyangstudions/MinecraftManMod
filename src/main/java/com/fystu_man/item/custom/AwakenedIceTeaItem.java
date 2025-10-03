package com.fystu_man.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class AwakenedIceTeaItem extends SwordItem {

    public AwakenedIceTeaItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable("tooltip.fystu_man.awakened_ice_tea.line1"));
        tooltip.add(Text.translatable("tooltip.fystu_man.awakened_ice_tea.line2"));
        tooltip.add(Text.translatable("tooltip.fystu_man.awakened_ice_tea.line3"));
        tooltip.add(Text.translatable("tooltip.fystu_man.awakened_ice_tea.line4"));
        tooltip.add(Text.translatable("tooltip.fystu_man.awakened_ice_tea.line5"));
        tooltip.add(Text.translatable("tooltip.fystu_man.awakened_ice_tea.line6"));

        super.appendTooltip(stack, context, tooltip, type);
    }
}
