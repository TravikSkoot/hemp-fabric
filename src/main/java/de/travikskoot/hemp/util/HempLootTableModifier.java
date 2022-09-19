package de.travikskoot.hemp.util;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.item.HempItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class HempLootTableModifier {

    public static void registerLootTables() {
        Hemp.LOGGER.debug("Registering Loot Tables for " + Hemp.MOD_ID);
    }

    private static final Identifier VILLAGE_DESERT_HOUSE_CHEST = new Identifier("minecraft",
            "chests/village/village_desert_house");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (VILLAGE_DESERT_HOUSE_CHEST.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(UniformLootNumberProvider.create(1, 3))
                        .bonusRolls(ConstantLootNumberProvider.create(0))
                        .with(ItemEntry.builder(HempItems.HEMP_LEAF));
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
