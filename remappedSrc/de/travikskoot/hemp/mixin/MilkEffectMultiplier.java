package de.travikskoot.hemp.mixin;


import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(MilkBucketItem.class)
public class MilkEffectMultiplier {
    @Inject(at = @At("HEAD"), method = "finishUsing")
    private void injectHempMilkEffectMultiplier(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (!world.isClient) {
            if(user.hasStatusEffect(HempStatusEffect.STONED)) {
                //TODO Override removing all effects
                user.addStatusEffect(new StatusEffectInstance(HempStatusEffect.STONED, 3600, 2));
            }
        }
        //TODO andere effekte nicht vergessen ;)
    }
}

