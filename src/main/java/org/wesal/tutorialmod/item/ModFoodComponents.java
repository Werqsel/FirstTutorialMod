package org.wesal.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;

public class ModFoodComponents {
    public static final FoodComponent COUILFLOWER = new FoodComponent.Builder()
            .nutrition(3)
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED,5,100),1)
            .alwaysEdible()
            .build();
    public static final FoodComponent LIGHTNING_DRINK = new FoodComponent.Builder()
            .saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST,10,100),1.0f)
            .alwaysEdible()
            .build();
}
