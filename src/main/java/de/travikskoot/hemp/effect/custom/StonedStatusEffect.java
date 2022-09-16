package de.travikskoot.hemp.effect.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;

public class StonedStatusEffect extends StatusEffect {
    public StonedStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity){
            if (!entity.hasStatusEffect(HempStatusEffect.STONED)) {
                entity.removeStatusEffect(StatusEffects.REGENERATION);
                entity.removeStatusEffect(StatusEffects.JUMP_BOOST);
                //TODO remove other effects when effect is expired
            }
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 999999));
            entity.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 999999));
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}
