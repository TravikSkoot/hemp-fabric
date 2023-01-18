package de.travikskoot.hemp.effect.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class HighStatusEffect extends StatusEffect {
    public HighStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 5210, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 5210, amplifier, false, false, false));
        super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.hasStatusEffect(HempStatusEffect.HIGH)) {
            entity.removeStatusEffect(StatusEffects.SPEED);
            entity.removeStatusEffect(StatusEffects.WEAKNESS);
        }
        super.onRemoved(entity, attributes, amplifier);
    }
}
