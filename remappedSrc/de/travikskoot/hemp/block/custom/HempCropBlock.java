package de.travikskoot.hemp.block.custom;

import de.travikskoot.hemp.item.HempItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CropBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemConvertible;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class HempCropBlock extends CropBlock {
    public HempCropBlock(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemConvertible getSeedsItem() {
        return HempItems.HEMP_SEEDS;
    }
}
