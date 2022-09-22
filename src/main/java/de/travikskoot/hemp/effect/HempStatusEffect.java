package de.travikskoot.hemp.effect;

import de.travikskoot.hemp.Hemp;
import de.travikskoot.hemp.effect.custom.BadTripStatusEffect;
import de.travikskoot.hemp.effect.custom.HighStatusEffect;
import de.travikskoot.hemp.effect.custom.StonedStatusEffect;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class HempStatusEffect {

    public static final StatusEffect STONED = registerStatusEffect("stoned",
            new StonedStatusEffect(StatusEffectCategory.BENEFICIAL, 0x197a17));

    public static final StatusEffect HIGH = registerStatusEffect("high",
            new HighStatusEffect(StatusEffectCategory.BENEFICIAL, 0x197a17));

    public static final StatusEffect BAD_TRIP = registerStatusEffect("bad_trip",
            new BadTripStatusEffect(StatusEffectCategory.BENEFICIAL, 0x197a17));

    // register the effect
    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Hemp.MOD_ID, name), effect);
    }

    public static void registerHempEffects() {
        Hemp.LOGGER.debug("Registering Mod Status Effects for " + Hemp.MOD_ID);
    }
}
