package de.travikskoot.hemp.effect;

import de.travikskoot.hemp.Hemp;
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

                    /*.addAttributeModifier((EntityAttributes.GENERIC_MOVEMENT_SPEED),
                            "7107DE5E-7CE8-4030-940E-514C1F160890",
                            -0.15f,
                            EntityAttributeModifier.Operation.MULTIPLY_TOTAL))
                    .addAttributeModifier(EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            "648D7064-6A60-4F59-8ABE-C2C23A6DD7A9",
                            1.0,
                            EntityAttributeModifier.Operation.ADDITION);

                     */

    //Item Register
    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registry.STATUS_EFFECT, new Identifier(Hemp.MOD_ID, name), effect);
    }
    public static void registerHempEffects() {
        Hemp.LOGGER.debug("Registering Mod Status Effects for " + Hemp.MOD_ID);
    }
}
