package de.travikskoot.hemp.item.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BongItem extends Item {
    public BongItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(!world.isClient && (hand == Hand.MAIN_HAND || hand == Hand.OFF_HAND)) {
            if(!user.isSubmergedInWater()) {
                user.playSound(SoundEvents.BLOCK_SMOKER_SMOKE, SoundCategory.PLAYERS, 2, 1);
                user.playSound(SoundEvents.BLOCK_BUBBLE_COLUMN_WHIRLPOOL_AMBIENT, SoundCategory.PLAYERS, 1, 1);
                user.addStatusEffect(new StatusEffectInstance(HempStatusEffect.STONED, 3600));
                user.getStackInHand(hand).damage(1, user, p -> p.sendToolBreakStatus(hand));

                ServerWorld serverWorld = (ServerWorld)world;
                if (user.getHorizontalFacing() == Direction.NORTH) {
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE,
                            user.getX(), user.getY() + 2, user.getZ() - 0.35, 50, 0.1, 0.5, 0.1, 0);
                    serverWorld.spawnParticles(ParticleTypes.SMALL_FLAME,
                            user.getX(), user.getY() + 0.9, user.getZ() - 0.25, 10, 0.1, 0.1, 0.1, 0);
                } else if (user.getHorizontalFacing() == Direction.EAST) {
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE,
                            user.getX() + 0.35, user.getY() + 2, user.getZ(), 50, 0.1, 0.5, 0.1, 0);
                    serverWorld.spawnParticles(ParticleTypes.SMALL_FLAME,
                            user.getX() + 0.25, user.getY() + 0.9, user.getZ(), 10, 0.1, 0.1, 0.1, 0);
                } else if (user.getHorizontalFacing() == Direction.SOUTH) {
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE,
                            user.getX(), user.getY() + 2, user.getZ() + 0.35, 50, 0.1, 0.5, 0.1, 0);
                    serverWorld.spawnParticles(ParticleTypes.SMALL_FLAME,
                            user.getX(), user.getY() + 0.9, user.getZ() + 0.25, 10, 0.1, 0.1, 0.1, 0);
                } else if (user.getHorizontalFacing() == Direction.WEST) {
                    serverWorld.spawnParticles(ParticleTypes.LARGE_SMOKE,
                            user.getX() - 0.35, user.getY() + 2, user.getZ(), 50, 0.1, 0.5, 0.1, 0);
                    serverWorld.spawnParticles(ParticleTypes.SMALL_FLAME,
                            user.getX() - 0.25, user.getY() + 0.9, user.getZ(), 10, 0.1, 0.1, 0.1, 0);
                }
                // TODO Green View
            } else {
                user.sendMessage(Text.translatable("message.hemp.underwater").formatted(Formatting.RED), true);
            }
        }

        return super.use(world, user, hand);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.hemp.tooltip.shift").formatted(Formatting.GREEN));
        } else {
            tooltip.add(Text.translatable("item.hemp.tooltip").formatted(Formatting.AQUA));
        }
        super.appendTooltip(stack, world, tooltip, context);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.TOOT_HORN;
    }

    @Override
    public boolean isDamageable() {
        return super.isDamageable();
    }
}
