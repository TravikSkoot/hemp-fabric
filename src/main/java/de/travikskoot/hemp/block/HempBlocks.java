package de.travikskoot.hemp.block;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.block.custom.*;
import de.travikskoot.hemp.item.HempItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class HempBlocks {

    //Instance Creation of Block
    public static final Block HEMP_BLOCK = registerBlock("hemp_block",
            new HempBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.5f).sounds(BlockSoundGroup.GRASS)), HempItemGroup.HEMP);

    public static final Block WET_HEMP_BLOCK = registerBlock("wet_hemp_block",
            new WetHempBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.5f).sounds(BlockSoundGroup.GRASS)), HempItemGroup.HEMP);

    public static final Block STASH_JAR = registerBlock("stash_jar",
            new StashJarBlock(FabricBlockSettings.of(Material.GLASS).strength(2f).nonOpaque().sounds(BlockSoundGroup.GLASS)), HempItemGroup.HEMP);

    public static final Block HEMP_CROP = registerBlockWithoutItem("hemp_crop",
            new HempCropBlock(FabricBlockSettings.of(Material.PLANT).nonOpaque().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Hemp.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Hemp.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Hemp.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    private static void addBlocksToItemGroup() {
        //vanilla itemgroups
        addToItemGroup(ItemGroups.NATURAL, HEMP_BLOCK);
        addToItemGroup(ItemGroups.NATURAL, WET_HEMP_BLOCK);
        addToItemGroup(ItemGroups.BUILDING_BLOCKS, STASH_JAR);
        addToItemGroup(ItemGroups.FUNCTIONAL, STASH_JAR);

        //hemp itemgroups
        addToItemGroup(HempItemGroup.HEMP, HEMP_BLOCK);
        addToItemGroup(HempItemGroup.HEMP, WET_HEMP_BLOCK);
        addToItemGroup(HempItemGroup.HEMP, STASH_JAR);
    }

    private static void addToItemGroup(ItemGroup group, Block block) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(block));
    }

    public static void registerFlammableBlocks() {
        FlammableBlockRegistry registry = FlammableBlockRegistry.getDefaultInstance();

        registry.add(HempBlocks.HEMP_BLOCK, 60, 20);
    }

    public static void registerHempBlocks() {
        Hemp.LOGGER.debug("Registering Mod Blocks for " + Hemp.MOD_ID);
        addBlocksToItemGroup();
        registerFlammableBlocks();
    }
}
