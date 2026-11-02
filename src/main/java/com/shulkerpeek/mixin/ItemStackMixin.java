package com.shulkerpeek.mixin;

import com.shulkerpeek.client.ShulkerTooltipData;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {
    @Inject(method = "getTooltipData", at = @At("HEAD"), cancellable = true)
    private void shulkerpeek$getShulkerTooltipData(CallbackInfoReturnable<Optional<TooltipData>> cir) {
        ItemStack self = (ItemStack) (Object) this;
        if (self.getItem() instanceof BlockItem blockItem && blockItem.getBlock() instanceof ShulkerBoxBlock) {
            ContainerComponent container = self.get(DataComponentTypes.CONTAINER);
            if (container != null && !container.stream().allMatch(ItemStack::isEmpty)) {
                cir.setReturnValue(Optional.of(new ShulkerTooltipData(container)));
            }
        }
    }
}
