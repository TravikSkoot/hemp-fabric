package de.travikskoot.hemp.block;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.item.HempItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class HempBlocks {

    //Instance Creation of Block
    public static final Block HEMP_BLOCK = registerBlock("hemp_block", new Block(FabricBlockSettings.create()
            .mapColor(MapColor.GREEN)
            .instrument(Instrument.BANJO)
            .strength(0.5f)
            .sounds(BlockSoundGroup.GRASS)), HempItemGroup.HEMP);

    public static final Block WET_HEMP_BLOCK = registerBlock("wet_hemp_block", new Block(FabricBlockSettings.create()
            .mapColor(MapColor.GREEN)
            .strength(0.6f)
            .sounds(BlockSoundGroup.GRASS)), HempItemGroup.HEMP);
    public static final Block STASH_JAR = registerBlock("stash_jar", new Block(FabricBlockSettings.create()
            .instrument(Instrument.HAT)
            .strength(0.3f)
            .sounds(BlockSoundGroup.GLASS)
            .nonOpaque()
            .allowsSpawning(Blocks::never)
            .solidBlock(Blocks::never)
            .suffocates(Blocks::never)
            .blockVision(Blocks::never)), HempItemGroup.HEMP);

    public static final Block HEMP_CROP = registerBlock("hemp_crop", new Block(FabricBlockSettings.create()
            .mapColor(MapColor.DARK_GREEN)
            .noCollision()
            .ticksRandomly()
            .breakInstantly()
            .sounds(BlockSoundGroup.CROP)
            .pistonBehavior(PistonBehavior.DESTROY)), HempItemGroup.HEMP);

    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Hemp.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, RegistryKey<ItemGroup> group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Hemp.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, RegistryKey<ItemGroup> group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Hemp.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> content.add(item));
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

    private static void addToItemGroup(RegistryKey<ItemGroup> group, Block block) {
        ItemGroupEvents.modifyEntriesEvent(group).register(content -> content.add(block));
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
