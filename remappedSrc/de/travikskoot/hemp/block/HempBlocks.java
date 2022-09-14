package de.travikskoot.hemp.block;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.item.HempItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HempBlocks {

    //Instance Creation of Block
    public static final Block HEMP_BLOCK = registerBlock("hemp_block", new Block(FabricBlockSettings.of(Material.LEAVES)), HempItemGroup.HEMP);
    public static final Block WET_HEMP_BLOCK = registerBlock("wet_hemp_block", new Block(FabricBlockSettings.of(Material.LEAVES).strength(4f)), HempItemGroup.HEMP);

    //Block Register
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
    public static void registerModBlocks() {
        Hemp.LOGGER.debug("Registering Mod Blocks for " + Hemp.MOD_ID);
    }
}
