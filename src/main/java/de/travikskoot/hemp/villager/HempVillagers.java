package de.travikskoot.hemp.villager;

import com.google.common.collect.ImmutableSet;
import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.block.HempBlocks;
import de.travikskoot.hemp.item.HempItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.object.builder.v1.villager.VillagerProfessionBuilder;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class HempVillagers {

    public static void registerHempVillagers() {
        Hemp.LOGGER.debug("Registering Mod Villagers for " + Hemp.MOD_ID);
    }

    public static final PointOfInterestType HEMP_POI = registerPOI("hemp_poi", HempBlocks.HEMP_BLOCK);
    public static final VillagerProfession HEMP_FARMER = registerProfession("hemp_farmer",
            RegistryKey.of(Registry.POINT_OF_INTEREST_TYPE_KEY, new Identifier(Hemp.MOD_ID, "hemp_poi")));

    public static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registry.VILLAGER_PROFESSION, new Identifier(Hemp.MOD_ID, name),
                VillagerProfessionBuilder.create().id(new Identifier(Hemp.MOD_ID, name))
                        .workstation(type).workSound(SoundEvents.ENTITY_VILLAGER_WORK_FARMER).build());
    }

    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(Hemp.MOD_ID, name),
                1,1,ImmutableSet.copyOf(block.getStateManager().getStates()));
    }

    public static void registerHempTrades() {
        TradeOfferHelper.registerVillagerOffers(HEMP_FARMER, 1, factories -> {
            factories.add((entity, random) -> new TradeOffer(
                    new ItemStack(Items.EMERALD, 1),
                    new ItemStack(HempItems.HEMP_LEAF, 3),
                    6,
                    2,
                    0.05f
            ));
        });
    }

}
