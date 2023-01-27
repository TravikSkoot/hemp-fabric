package de.travikskoot.hemp.item;

import de.travikskoot.hemp.Hemp;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HempItemGroup {

    public static final ItemGroup HEMP = FabricItemGroup.builder(new Identifier(Hemp.MOD_ID, "hemp"))
            .displayName(Text.literal("Hemp"))
            .icon(() -> new ItemStack(HempItems.HEMP_LEAF)).build();

    //Console Output
    public static void registerHempItemGroup() {
        Hemp.LOGGER.debug("Registering Mod ItemGroup for " + Hemp.MOD_ID);
    }
}
