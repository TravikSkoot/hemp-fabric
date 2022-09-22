package de.travikskoot.hemp.effect.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.*;
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
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS));
        super.applyUpdateEffect(entity, amplifier);
    }
}
