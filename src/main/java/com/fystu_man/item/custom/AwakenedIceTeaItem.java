package com.fystu_man.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class AwakenedIceTeaItem extends SwordItem {

    public AwakenedIceTeaItem(ToolMaterial toolMaterial, Settings settings) {
        super(toolMaterial, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        this.tooltip = tooltip;
        addDelimiter();
        add("tooltip.fystu_man.awakened_ice_tea.line1");
        addDelimiter();
        add("tooltip.fystu_man.awakened_ice_tea.line2");
        add("tooltip.fystu_man.awakened_ice_tea.line3");
        addDelimiter();

        super.appendTooltip(stack, context, tooltip, type);
    }

    private List<Text> tooltip;
    private void add(String translatableKey) {tooltip.add(Text.translatable(translatableKey));}
    private void addDelimiter() {tooltip.add(Text.translatable("tooltip.fystu_man.__ALL__.delimiter"));}
}
