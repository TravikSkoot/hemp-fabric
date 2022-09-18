package de.travikskoot.hemp.block.custom;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class HempSoilBlock extends FarmlandBlock {
    public static final IntProperty MOISTURE = IntProperty.of("moisture", 0, 7);
    protected static final VoxelShape SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 15.0, 16.0);

    public HempSoilBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(MOISTURE, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MOISTURE);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(MOISTURE);
        if (isWaterNearby(world, pos) || world.hasRain(pos.up())) {
            if (i < 7) {
                world.setBlockState(pos, state.with(MOISTURE, 7), Block.NOTIFY_LISTENERS);
            }
        } else if (i > 0) {
            world.setBlockState(pos, state.with(MOISTURE, i - 1), Block.NOTIFY_LISTENERS);
        } else if (!hasCrop(world, pos)) {
            FarmlandBlock.setToDirt(state, world, pos);
        }
    }

    private static boolean isWaterNearby(WorldView world, BlockPos pos) {
        for (BlockPos blockPos : BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 1, 4))) {
            if (!world.getFluidState(blockPos).isIn(FluidTags.WATER)) continue;
            return true;
        }
        return false;
    }

    private static boolean hasCrop(BlockView world, BlockPos pos) {
        Block block = world.getBlockState(pos.up()).getBlock();
        return block instanceof CropBlock || block instanceof StemBlock || block instanceof AttachedStemBlock;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
