package de.travikskoot.hemp.item;

import de.travikskoot.hemp.Hemp;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class HempItemGroup {
    //
    public static final ItemGroup HEMP = FabricItemGroupBuilder.build(new Identifier(Hemp.MOD_ID,
            "hemp"), () -> new ItemStack(HempItems.HEMP_LEAF));
}
