package de.travikskoot.hemp.screen;

import de.travikskoot.hemp.screen.custom.RollingTrayScreenHandler;
import net.minecraft.screen.ScreenHandlerType;

public class HempScreenHandlers {
    public static ScreenHandlerType<RollingTrayScreenHandler> ROLLING_TRAY_SCREEN_HANDLER;

    public static void registerAllScreenHandlers() {
        ROLLING_TRAY_SCREEN_HANDLER = new ScreenHandlerType<>(RollingTrayScreenHandler::new);
    }
}
