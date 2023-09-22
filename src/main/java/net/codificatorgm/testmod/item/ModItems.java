package net.codificatorgm.testmod.item;

import net.codificatorgm.testmod.TestMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> WEED = ITEMS.register("weed",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JOINT = ITEMS.register("joint",
            () -> new Item(new Item.Properties().food(ModFoods.JOINT)));

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }
}
