package de.travikskoot.hemp.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.entity.Entity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class WetHempBlock extends PillarBlock {
    public WetHempBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)this.stateManager.getDefaultState()).with(AXIS, Direction.Axis.Y));
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.handleFallDamage(fallDistance, 0.2f, world.getDamageSources().fall());
    }

    //Water Particles like the Sponge Block
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = Direction.random(random);
        if (direction == Direction.UP) {
            return;
        }
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (state.isOpaque() && blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
            return;
        }
        double x = pos.getX();
        double y = pos.getY();
        double z = pos.getZ();
        if (direction == Direction.DOWN) {
            y -= 0.05;
            x += random.nextDouble();
            z += random.nextDouble();
        } else {
            y += random.nextDouble() * 0.8;
            if (direction.getAxis() == Direction.Axis.X) {
                z += random.nextDouble();
                x = direction == Direction.EAST ? (x += 1.1) : (x += 0.05);
            } else {
                x += random.nextDouble();
                z = direction == Direction.SOUTH ? (z += 1.1) : (z += 0.05);
            }
        }
        world.addParticle(ParticleTypes.DRIPPING_WATER, x, y, z, 0.0, 0.0, 0.0);
    }
}
