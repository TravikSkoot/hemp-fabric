package de.travikskoot.hemp.client;

import de.travikskoot.hemp.block.HempBlocks;
import de.travikskoot.hemp.screen.HempScreenHandlers;
import de.travikskoot.hemp.screen.custom.RollingTrayScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class HempClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(HempBlocks.HEMP_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(HempBlocks.STASH_JAR, RenderLayer.getCutout());
        HandledScreens.register(HempScreenHandlers.ROLLING_TRAY_SCREEN_HANDLER, RollingTrayScreen::new);
    }
}
