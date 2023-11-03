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
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

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
            new JointItem(new FabricItemSettings().maxDamage(10)));
    public static final Item HEMP_SEEDS = registerItem("hemp_seeds",
            new AliasedBlockItem(HempBlocks.HEMP_CROP,new FabricItemSettings()));
    public static final Item GRINDER = registerItem("grinder",
            new GrinderItem(new FabricItemSettings()));
    public static final Item DRY_HEMP = registerItem("dry_hemp",
            new Item(new FabricItemSettings()));
    public static final Item WET_HEMP = registerItem("wet_hemp",
            new Item(new FabricItemSettings()));
    public static final Item BONG = registerItem("bong",
            new BongItem(new FabricItemSettings().maxDamage(3)));
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
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, HEMP_LEAF);
        addToItemGroup(ItemGroups.INGREDIENTS, HEMP_SEEDS);
        addToItemGroup(ItemGroups.INGREDIENTS, DRY_HEMP);
        addToItemGroup(ItemGroups.INGREDIENTS, WET_HEMP);
        addToItemGroup(ItemGroups.TOOLS, JOINT);
        addToItemGroup(ItemGroups.TOOLS, BONG);
        addToItemGroup(ItemGroups.TOOLS, GRINDER);
        addToItemGroup(ItemGroups.INGREDIENTS, BROWNIE);
        addToItemGroup(ItemGroups.FOOD_AND_DRINK, BROWNIE);

        //hemp itemgroup
        addToItemGroup(HempItemGroup.HEMP, HEMP_LEAF);
        addToItemGroup(HempItemGroup.HEMP, HEMP_SEEDS);
        addToItemGroup(HempItemGroup.HEMP, DRY_HEMP);
        addToItemGroup(HempItemGroup.HEMP, WET_HEMP);
        addToItemGroup(HempItemGroup.HEMP, JOINT);
        addToItemGroup(HempItemGroup.HEMP, BONG);
        addToItemGroup(HempItemGroup.HEMP, GRINDER);
        addToItemGroup(HempItemGroup.HEMP, BROWNIE);
    }

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    //Console Output
    public static void registerHempItems() {
        Hemp.LOGGER.debug("Registering Mod Items for " + Hemp.MOD_ID);
        addItemsToItemGroup();
    }

}