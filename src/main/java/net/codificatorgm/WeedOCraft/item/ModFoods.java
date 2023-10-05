
package net.codificatorgm.WeedOCraft.item;

import net.minecraft.world.effect.*;
import net.minecraft.world.food.FoodProperties;


public class ModFoods {
    public static final FoodProperties PURPLE_HAZE_JOINT = new FoodProperties.Builder().nutrition(0)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    340), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 340), 1f).
            effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500), 1f).
            alwaysEat().build();

    public static final FoodProperties CANNAMILK = new FoodProperties.Builder().nutrition(0)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    300), 1f).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1800), 0.90f).
            effect(() -> new MobEffectInstance(MobEffects.HEAL, 5), 1f).
            alwaysEat().build();

    public static final FoodProperties WEED_COOKIE = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    350), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1200), 1f).
            effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1800), 1f).
            effect(() -> new MobEffectInstance(MobEffects.LUCK, 3600), 1f).
            effect(() -> new MobEffectInstance(MobEffects.HUNGER, 700), 0.05f).
            build();

    public static final FoodProperties WEED_BROWNIE = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    500), 1f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 1800), 1f).
            effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 700), 1f).
            effect(() -> new MobEffectInstance(MobEffects.HUNGER, 700), 0.05f).
            build();

    public static final FoodProperties WEED_MUFFIN = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    400), 1f).effect(() -> new MobEffectInstance(MobEffects.NIGHT_VISION, 3600), 1f).
            effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 500), 1f).
            effect(() -> new MobEffectInstance(MobEffects.HUNGER, 700), 0.05f).
            build();

    public static final FoodProperties GRAPEFRUIT_SODA = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    1200), 1f).effect(() -> new MobEffectInstance(MobEffects.LUCK, 3600), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 5, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 120, 1), 0.20f)
            .fast().alwaysEat().build();

    public static final FoodProperties LEMON_SODA = new FoodProperties.Builder().nutrition(1)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.CONFUSION,
                    1200), 1f).effect(() -> new MobEffectInstance(MobEffects.LUCK, 3600), 1f).
            effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 1), 1f)
            .effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 120, 2), 0.20f)
            .fast().alwaysEat().build();
}
