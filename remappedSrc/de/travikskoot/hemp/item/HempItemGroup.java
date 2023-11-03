package de.travikskoot.hemp.item;

import de.travikskoot.hemp.Hemp;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class HempItemGroup {

    public static final RegistryKey<ItemGroup> HEMP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(Hemp.MOD_ID, "hemp"));


    //Console Output
    public static void registerHempItemGroup() {
        Hemp.LOGGER.debug("Registering Mod ItemGroup for " + Hemp.MOD_ID);
        Registry.register(Registries.ITEM_GROUP, HEMP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(HempItems.HEMP_LEAF))
                .displayName(Text.translatable("itemGroup.hemp.hemp"))
                .build());

    }
}
