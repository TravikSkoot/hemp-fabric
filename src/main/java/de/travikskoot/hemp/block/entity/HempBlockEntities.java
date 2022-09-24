package de.travikskoot.hemp.block.entity;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.block.HempBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class HempBlockEntities {
    public static BlockEntityType<RollingTrayBlockEntity> ROLLING_TRAY;

    public static void registerHempBlockEntities() {
        ROLLING_TRAY = Registry.register(Registry.BLOCK_ENTITY_TYPE,
                new Identifier(Hemp.MOD_ID, "rolling_tray"),
                FabricBlockEntityTypeBuilder.create(RollingTrayBlockEntity::new,
                        HempBlocks.ROLLING_TRAY).build(null));
    }
}
