package de.travikskoot.hemp.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;


public class GrinderItem extends Item {
    public GrinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public UseAction getUseAction(ItemStack stack) {
        return UseAction.BOW;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            user.playSound(SoundEvents.BLOCK_GRINDSTONE_USE, SoundCategory.PLAYERS, 1, 1);
            user.getItemCooldownManager().set(this, 10);
        }
        return super.use(world, user, hand);
    }
}
