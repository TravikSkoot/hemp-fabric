package de.travikskoot.hemp.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

public class StashJarBlock extends Block {
    public StashJarBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(6, 0.20000000000000007, 6, 10, 0.4, 10),
            Block.createCuboidShape(6, 8, 6, 10, 9, 10),
            Block.createCuboidShape(10, 0, 6, 11, 1, 11),
            Block.createCuboidShape(10, 1, 10, 11, 7, 11),
            Block.createCuboidShape(5, 1, 10, 6, 7, 11),
            Block.createCuboidShape(5, 1, 5, 6, 7, 6),
            Block.createCuboidShape(10, 1, 5, 11, 7, 6),
            Block.createCuboidShape(5, 0, 5, 6, 1, 10),
            Block.createCuboidShape(6, 0, 5, 11, 1, 6),
            Block.createCuboidShape(5, 0, 10, 10, 1, 11),
            Block.createCuboidShape(6, 1, 10.4, 10, 7, 10.6),
            Block.createCuboidShape(6, 1, 5.4, 10, 7, 5.6),
            Block.createCuboidShape(10.4, 1, 6, 10.6, 7, 10),
            Block.createCuboidShape(5.4, 1, 6, 5.6, 7, 10),
            Block.createCuboidShape(10, 7, 6, 11, 8, 11),
            Block.createCuboidShape(5, 7, 5, 6, 8, 10),
            Block.createCuboidShape(5, 7, 10, 10, 8, 11),
            Block.createCuboidShape(6, 7, 5, 11, 8, 6),
            Block.createCuboidShape(6, 0.5999999999999996, 6, 10, 7, 10)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
}
