package com.fystu_man.item.custom;

import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;

import java.util.List;

public class GoldenTeaItem extends DrinkableItem {

    public GoldenTeaItem(Settings settings) {
        super(settings);
    }

    private List<Text> tooltip;
    private void add(String translatableKey) {tooltip.add(Text.translatable(translatableKey));}
    private void addDelimiter() {tooltip.add(Text.translatable("tooltip.fystu_man.__ALL__.delimiter"));}

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        this.tooltip = tooltip;
        addDelimiter();
        add("tooltip.fystu_man.golden_tea.line1");
        addDelimiter();
        add("tooltip.fystu_man.__ALL__.super_effect");
        add("tooltip.fystu_man.golden_tea.line2");
        addDelimiter();
    }
}
