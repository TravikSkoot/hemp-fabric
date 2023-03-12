package de.travikskoot.hemp.item.custom;

import de.travikskoot.hemp.item.HempItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;


public class GrinderItem extends Item {
    public GrinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BLOCK;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getStackInHand(hand);
        if (!world.isClient) {
            boolean foundDryHemp = false;
            // Look for dry hemp in inventory
            for (int i = 0; i < player.getInventory().size(); i++) {
                ItemStack itemStack = player.getInventory().getStack(i);
                if (itemStack.getItem() == HempItems.DRY_HEMP) {
                    foundDryHemp = true;
                    // Remove dry hemp from inventory
                    itemStack.decrement(3);
                    // Add 9 dry hemp pieces to inventory
                    player.getInventory().offerOrDrop(new ItemStack(HempItems.JOINT, 1));
                    player.playSound(SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.PLAYERS, 1, 1);
                    player.getStackInHand(hand).damage(1, player, p -> p.sendToolBreakStatus(hand));
                    player.getItemCooldownManager().set(this, 10);
                    return new TypedActionResult<>(ActionResult.SUCCESS, stack);
                }
            } if (!foundDryHemp) {
                player.sendMessage(Text.translatable("message.hemp.no_hemp").formatted(Formatting.RED), true);
                return new TypedActionResult<>(ActionResult.FAIL, stack);
            }
        }
        return new TypedActionResult<>(ActionResult.FAIL, stack);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
    }
}
