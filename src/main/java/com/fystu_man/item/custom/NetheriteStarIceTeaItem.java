package com.fystu_man.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class NetheriteStarIceTeaItem extends DrinkableItem {

    public NetheriteStarIceTeaItem(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        this.tooltip = tooltip;
        addDelimiter();
        add("tooltip.fystu_man.netherite_star_ice_tea.line1");
        addDelimiter();
        add("tooltip.fystu_man.netherite_star_ice_tea.line2");
        add("tooltip.fystu_man.netherite_star_ice_tea.line3");
        addDelimiter();

        super.appendTooltip(stack, context, tooltip, type);
    }

    private List<Text> tooltip;
    private void add(String translatableKey) {tooltip.add(Text.translatable(translatableKey));}
    private void addDelimiter() {tooltip.add(Text.translatable("tooltip.fystu_man.__ALL__.delimiter"));}
}
