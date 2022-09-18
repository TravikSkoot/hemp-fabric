package de.travikskoot.hemp.block;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.block.custom.*;
import de.travikskoot.hemp.item.HempItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;

public class HempBlocks {

    //Instance Creation of Block
    public static final Block HEMP_BLOCK = registerBlock("hemp_block",
            new HempBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.5f).sounds(BlockSoundGroup.GRASS)), HempItemGroup.HEMP);

    public static final Block WET_HEMP_BLOCK = registerBlock("wet_hemp_block",
            new WetHempBlock(FabricBlockSettings.of(Material.SOLID_ORGANIC, MapColor.GREEN).strength(0.5f).sounds(BlockSoundGroup.GRASS)), HempItemGroup.HEMP);

    public static final Block GROW_BOX = registerBlock("grow_box",
            new GrowBoxBlock(FabricBlockSettings.of(Material.SHULKER_BOX).strength(1f).nonOpaque()), HempItemGroup.HEMP);

    public static final Block HEMP_SOIL = registerBlock("hemp_soil",
            new HempSoilBlock(FabricBlockSettings.of(Material.SOIL)
                    .ticksRandomly().strength(0.6f).sounds(BlockSoundGroup.GRAVEL)
                    .blockVision(HempBlocks::always).suffocates(HempBlocks::always))
            ,HempItemGroup.HEMP);

    public static final Block HEMP_CROP = registerBlockWithoutItem("hemp_crop",
            new HempCropBlock(FabricBlockSettings.of(Material.PLANT).nonOpaque().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

    private static boolean always(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    //Block Register
    private static Block registerBlockWithoutItem(String name, Block block) {
        return Registry.register(Registry.BLOCK, new Identifier(Hemp.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block, ItemGroup tab) {
        registerBlockItem(name, block, tab);
        return Registry.register(Registry.BLOCK, new Identifier(Hemp.MOD_ID, name), block);
    }

    //Block Item Register
    private static Item registerBlockItem(String name, Block block, ItemGroup tab) {
        return Registry.register(Registry.ITEM, new Identifier(Hemp.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(tab)));
    }

    //Console Output
    public static void registerHempBlocks() {
        Hemp.LOGGER.debug("Registering Mod Blocks for " + Hemp.MOD_ID);
    }
}
