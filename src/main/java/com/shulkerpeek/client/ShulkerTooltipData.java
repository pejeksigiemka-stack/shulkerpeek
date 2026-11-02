package com.shulkerpeek.client;

import net.minecraft.component.type.ContainerComponent;
import net.minecraft.item.tooltip.TooltipData;

public record ShulkerTooltipData(ContainerComponent container) implements TooltipData {
}
