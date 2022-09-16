package de.travikskoot.hemp.item;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.item.custom.JointItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HempItems {

    //Instance Creation of Item
    public static final Item HEMP_LEAF = registerItem("hemp_leaf", new Item(new FabricItemSettings().group(HempItemGroup.HEMP)));
    public static final Item JOINT = registerItem("joint", new JointItem(new FabricItemSettings().group(HempItemGroup.HEMP)));
    public static final Item HEMP_SEEDS = registerItem("hemp_seeds", new Item(new FabricItemSettings().group(HempItemGroup.HEMP)));
    //public static final Item WET_HEMP = registerItem("wet_hemp", new Item(new FabricItemSettings().group(HempItemGroup.HEMP)));
    //public static final Item DRY_HEMP = registerItem("dry_hemp", new Item(new FabricItemSettings().group(HempItemGroup.HEMP)));
    //public static final Item GRINDER = registerItem("grinder", new Item(new FabricItemSettings().group(HempItemGroup.HEMP)));
    //public static final Item STASH = registerItem("stash", new Item(new FabricItemSettings().group(HempItemGroup.HEMP)));

    //Item Register
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Hemp.MOD_ID, name), item);
    }

    //Console Output
    public static void registerModItems() {
        Hemp.LOGGER.debug("Registering Mod Items for " + Hemp.MOD_ID);
    }

}
