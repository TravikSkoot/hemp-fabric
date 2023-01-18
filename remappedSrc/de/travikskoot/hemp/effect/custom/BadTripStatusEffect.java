package de.travikskoot.hemp.effect.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class BadTripStatusEffect extends StatusEffect {
    public BadTripStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5210, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 5210, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 5210, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 5210, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 5210, amplifier, false, false, false));
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.hasStatusEffect(HempStatusEffect.BAD_TRIP)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.NAUSEA);
            entity.removeStatusEffect(StatusEffects.BLINDNESS);
            entity.removeStatusEffect(StatusEffects.HUNGER);
            entity.removeStatusEffect(StatusEffects.POISON);
        }
        super.onRemoved(entity, attributes, amplifier);
    }
}
