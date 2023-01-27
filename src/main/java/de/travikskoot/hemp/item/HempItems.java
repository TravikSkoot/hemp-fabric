package de.travikskoot.hemp.item;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.block.HempBlocks;
import de.travikskoot.hemp.effect.HempStatusEffect;
import de.travikskoot.hemp.item.custom.BongItem;
import de.travikskoot.hemp.item.custom.GrinderItem;
import de.travikskoot.hemp.item.custom.JointItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class HempItems {

    //Instance Creation of Item
    public static final Item HEMP_LEAF = registerItem("hemp_leaf",
            new Item(new FabricItemSettings()
                    .food(new FoodComponent.Builder()
                            .hunger(1)
                            .saturationModifier(1f)
                            .alwaysEdible()
                            .statusEffect(new StatusEffectInstance(HempStatusEffect.STONED, 200, 0, false, true), 0.9f)
                            .build())));
    public static final Item JOINT = registerItem("joint",
            new JointItem(new FabricItemSettings()));
    public static final Item HEMP_SEEDS = registerItem("hemp_seeds",
            new AliasedBlockItem(HempBlocks.HEMP_CROP,new FabricItemSettings()));
    public static final Item GRINDER = registerItem("grinder",
            new GrinderItem(new FabricItemSettings()));
    public static final Item HEMP = registerItem("hemp",
            new Item(new FabricItemSettings()));
    public static final Item WET_HEMP = registerItem("wet_hemp",
            new Item(new FabricItemSettings()));
    public static final Item BONG = registerItem("bong",
            new BongItem(new FabricItemSettings()));
    public static final Item BROWNIE = registerItem("brownie",
                new Item(new FabricItemSettings()
                        .food(new FoodComponent.Builder()
                                .hunger(4)
                                .saturationModifier(4f)
                                .alwaysEdible()
                                .statusEffect(new StatusEffectInstance(HempStatusEffect.STONED, 3600, 1, false, true), 0.9f)
                                .build())));
    //Item Register
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Hemp.MOD_ID, name), item);
    }

    private static void addItemsToItemGroup() {
        //vanilla itemgroups
        addToItemGroup(ItemGroups.INGREDIENTS, HEMP_LEAF);
        addToItemGroup(ItemGroups.INGREDIENTS, HEMP_SEEDS);
        addToItemGroup(ItemGroups.INGREDIENTS, HEMP);
        addToItemGroup(ItemGroups.INGREDIENTS, WET_HEMP);
        addToItemGroup(ItemGroups.INGREDIENTS, JOINT);
        addToItemGroup(ItemGroups.INGREDIENTS, BONG);
        addToItemGroup(ItemGroups.INGREDIENTS, GRINDER);
        addToItemGroup(ItemGroups.INGREDIENTS, BROWNIE);

        //hemp itemgroups
        addToItemGroup(HempItemGroup.HEMP, HEMP_LEAF);
        addToItemGroup(HempItemGroup.HEMP, HEMP_SEEDS);
        addToItemGroup(HempItemGroup.HEMP, HEMP);
        addToItemGroup(HempItemGroup.HEMP, WET_HEMP);
        addToItemGroup(HempItemGroup.HEMP, JOINT);
        addToItemGroup(HempItemGroup.HEMP, BONG);
        addToItemGroup(HempItemGroup.HEMP, GRINDER);
        addToItemGroup(HempItemGroup.HEMP, BROWNIE);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    //Console Output
    public static void registerHempItems() {
        Hemp.LOGGER.debug("Registering Mod Items for " + Hemp.MOD_ID);
        addItemsToItemGroup();
    }

}
