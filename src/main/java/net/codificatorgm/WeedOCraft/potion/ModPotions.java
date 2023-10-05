package net.codificatorgm.WeedOCraft.potion;

import net.codificatorgm.WeedOCraft.TestMod;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, TestMod.MOD_ID);


    public static final RegistryObject<Potion> GRAPEFRUIT_SODA = POTIONS.register("grapefruit_sodas",
            () -> new Potion(new MobEffectInstance(MobEffects.CONFUSION, 1200),
                    new MobEffectInstance(MobEffects.LUCK, 3600),
                    new MobEffectInstance(MobEffects.HEAL, 5, 1),
                    new MobEffectInstance(MobEffects.LEVITATION, 120, 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }

}
