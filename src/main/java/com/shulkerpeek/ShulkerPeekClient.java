package com.shulkerpeek;

import com.shulkerpeek.client.ShulkerClientTooltipComponent;
import com.shulkerpeek.client.ShulkerTooltipData;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.TooltipComponentCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShulkerPeekClient implements ClientModInitializer {
    public static final String MOD_ID = "shulkerpeek";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        LOGGER.info("[ShulkerPeek] Initializing client shulker preview for Minecraft 1.21.11");

        TooltipComponentCallback.EVENT.register(data -> {
            if (data instanceof ShulkerTooltipData shulkerData) {
                return new ShulkerClientTooltipComponent(shulkerData);
            }
            return null;
        });
    }
}
