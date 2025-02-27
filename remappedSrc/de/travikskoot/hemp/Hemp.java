package de.travikskoot.hemp;

import de.travikskoot.hemp.block.HempBlocks;
import de.travikskoot.hemp.item.HempItemGroup;
import de.travikskoot.hemp.item.HempItems;
import de.travikskoot.hemp.effect.HempStatusEffect;
import de.travikskoot.hemp.util.HempLootTableModifier;
import de.travikskoot.hemp.villager.HempVillagers;
import de.travikskoot.hemp.world.gen.HempWorldGen;
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

        HempItems.registerHempItems();
        HempItemGroup.registerHempItemGroup();
        HempBlocks.registerHempBlocks();

        HempStatusEffect.registerHempEffects();

        HempVillagers.registerHempVillagers();
        HempVillagers.registerHempTrades();

        HempLootTableModifier.registerLootTables();
        HempLootTableModifier.modifyLootTables();

        HempWorldGen.generateWorldGen();

    }
}