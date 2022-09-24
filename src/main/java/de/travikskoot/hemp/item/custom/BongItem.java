package de.travikskoot.hemp.item.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
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
                user.playSound(SoundEvents.BLOCK_SMOKER_SMOKE, SoundCategory.PLAYERS, 1, 1);
                user.addStatusEffect(new StatusEffectInstance(HempStatusEffect.STONED, 3600));
            } else {
                user.sendMessage(Text.translatable("message.hemp.underwater").formatted(Formatting.RED));
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
}
