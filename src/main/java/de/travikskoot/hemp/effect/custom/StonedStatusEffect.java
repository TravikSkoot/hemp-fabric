package de.travikskoot.hemp.effect.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
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
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5200, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5200, amplifier, false, false, false));
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.hasStatusEffect(HempStatusEffect.STONED)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.STRENGTH);
        }
        super.onRemoved(entity, attributes, amplifier);
    }
}
