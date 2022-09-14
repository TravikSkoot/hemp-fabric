package de.travikskoot.hemp;

import de.travikskoot.hemp.block.HempBlocks;
import de.travikskoot.hemp.item.HempItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Logger
public class Hemp implements ModInitializer {
    public static final String MOD_ID = "hemp";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //Start Code
    @Override
    public void onInitialize() {
        LOGGER.info("Initializing " + MOD_ID);

        HempItems.registerModItems();
        HempBlocks.registerModBlocks();
    }
}