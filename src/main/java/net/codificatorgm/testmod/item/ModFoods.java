package net.codificatorgm.testmod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties JOINT = new FoodProperties.Builder().nutrition(0)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    300), 1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300), 1f).
            effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500), 1f).
            alwaysEat().build();

    public static final FoodProperties PURPLE_HAZE_JOINT = new FoodProperties.Builder().nutrition(0)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    340), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 340), 1f).
            effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500), 1f).
            alwaysEat().build();

    public static final FoodProperties BLUNT = new FoodProperties.Builder().nutrition(0)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    400), 1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500), 1f).
            alwaysEat().build();

    public static final FoodProperties PURPLE_HAZE_BLUNT = new FoodProperties.Builder().nutrition(0)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    400), 1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 600), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 700), 1f).
            effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 700), 0.50f).
            alwaysEat().build();
}
