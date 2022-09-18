package de.travikskoot.hemp.block.custom;

import de.travikskoot.hemp.item.HempItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class HempCropBlock extends CropBlock {
    public HempCropBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ItemConvertible getSeedsItem() {
        return HempItems.HEMP_SEEDS;
    }
}
