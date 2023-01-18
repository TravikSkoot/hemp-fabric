package de.travikskoot.hemp.item;

import de.travikskoot.hemp.Hemp;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.util.Identifier;

public class HempItemGroup {
    //
    public static final ItemGroup HEMP = new FabricItemGroup(new Identifier(Hemp.MOD_ID, "hemp")) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(HempItems.HEMP_LEAF);
        }

        @Override
        protected void addItems(FeatureSet enabledFeatures, Entries entries) {
            entries.add(HempItems.HEMP_LEAF);
            entries.add(HempItems.HEMP_SEEDS);
            entries.add(HempItems.HEMP);
            entries.add(HempItems.WET_HEMP);
            entries.add(HempItems.JOINT);
            entries.add(HempItems.BONG);
            entries.add(HempItems.GRINDER);
        }
    };
}
