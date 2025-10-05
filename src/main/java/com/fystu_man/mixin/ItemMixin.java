package com.fystu_man.mixin;

import com.fystu_man.item.ManModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Set;

@Mixin(Item.class)
public class ItemMixin {

    @Unique
    private static final Set<Item> GLINT_ITEMS = Set.of(
            ManModItems.AWAKENED_ICE_TEA,
            ManModItems.NETHER_STAR_ICE_TEA,
            ManModItems.GOLDEN_ICE_TEA
    );

    @Inject(method = "hasGlint", at = @At("HEAD"), cancellable = true)
    private void forceGlint(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (GLINT_ITEMS.contains(stack.getItem())) {
            cir.setReturnValue(true);
        }
    }
}