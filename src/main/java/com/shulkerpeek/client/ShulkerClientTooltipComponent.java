package com.shulkerpeek.client;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.tooltip.TooltipComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public class ShulkerClientTooltipComponent implements TooltipComponent {
    private static final int SLOT_SIZE = 18;
    private static final int COLUMNS = 9;
    private static final int ROWS = 3;
    private static final int TOTAL_SLOTS = COLUMNS * ROWS;

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(TOTAL_SLOTS, ItemStack.EMPTY);

    public ShulkerClientTooltipComponent(ShulkerTooltipData data) {
        data.container().copyTo(this.items);
    }

    @Override
    public int getHeight(TextRenderer textRenderer) {
        return ROWS * SLOT_SIZE + 4;
    }

    @Override
    public int getWidth(TextRenderer textRenderer) {
        return COLUMNS * SLOT_SIZE + 4;
    }

    @Override
    public void drawItems(TextRenderer textRenderer, int x, int y, int width, int height, DrawContext context) {
        int bgX = x;
        int bgY = y;
        int bgWidth = COLUMNS * SLOT_SIZE + 4;
        int bgHeight = ROWS * SLOT_SIZE + 4;

        // Outer border
        context.fill(bgX, bgY, bgX + bgWidth, bgY + bgHeight, 0xFF373737);
        // Inner background
        context.fill(bgX + 1, bgY + 1, bgX + bgWidth - 1, bgY + bgHeight - 1, 0xE0101010);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMNS; col++) {
                int index = col + row * COLUMNS;
                int slotX = bgX + 2 + col * SLOT_SIZE;
                int slotY = bgY + 2 + row * SLOT_SIZE;

                // Slot background box
                context.fill(slotX, slotY, slotX + SLOT_SIZE - 1, slotY + SLOT_SIZE - 1, 0x25FFFFFF);

                ItemStack stack = this.items.get(index);
                if (!stack.isEmpty()) {
                    context.drawItem(stack, slotX + 1, slotY + 1);
                    context.drawStackOverlay(textRenderer, stack, slotX + 1, slotY + 1);
                }
            }
        }
    }
}
