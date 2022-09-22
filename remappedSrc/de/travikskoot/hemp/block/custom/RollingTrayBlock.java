package de.travikskoot.hemp.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

import java.util.stream.Stream;

public class RollingTrayBlock extends HorizontalFacingBlock {
        public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public RollingTrayBlock(Settings settings) {
        super(settings);
    }

    public static final VoxelShape SHAPE = Stream.of(
            Block.createCuboidShape(2, 1, 12, 14, 2, 13),
            Block.createCuboidShape(1, 1, 4, 2, 2, 12.000000000000002),
            Block.createCuboidShape(14, 1, 4, 15, 2, 12.000000000000002),
            Block.createCuboidShape(2, 1, 3, 14, 2, 4),
            Block.createCuboidShape(2, 0, 4, 14, 1, 12)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public static final VoxelShape SHAPE_ROTATED = Stream.of(
            Block.createCuboidShape(3, 1, 2, 4, 2, 14),
            Block.createCuboidShape(3.9999999999999982, 1, 1, 12, 2, 2),
            Block.createCuboidShape(3.9999999999999982, 1, 14, 12, 2, 15),
            Block.createCuboidShape(12, 1, 2, 13, 2, 14),
            Block.createCuboidShape(4, 0, 2, 12, 1, 14)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction) state.get(FACING)) {
            default:
                return SHAPE;
            case EAST:
                return SHAPE_ROTATED;
            case SOUTH:
                return SHAPE;
            case WEST:
                return SHAPE_ROTATED;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
