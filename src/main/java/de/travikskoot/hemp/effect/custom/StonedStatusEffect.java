package de.travikskoot.hemp.effect.custom;

import de.travikskoot.hemp.effect.HempStatusEffect;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

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
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 5210, amplifier,false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 5210, amplifier, false, false, false));
        entity.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 5210, amplifier, false, false, false));
        super.applyUpdateEffect(entity, amplifier);
        //TODO: add shader effect
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.hasStatusEffect(HempStatusEffect.STONED)) {
            entity.removeStatusEffect(StatusEffects.SLOWNESS);
            entity.removeStatusEffect(StatusEffects.STRENGTH);
            entity.removeStatusEffect(StatusEffects.REGENERATION);
        }
        super.onRemoved(entity, attributes, amplifier);
    }

}
