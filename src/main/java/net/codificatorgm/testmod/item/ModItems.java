package net.codificatorgm.testmod.item;

import net.codificatorgm.testmod.TestMod;
import net.codificatorgm.testmod.block.ModBlocks;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> WEED_LEAF = ITEMS.register("weed_leaf",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WEED_BUD = ITEMS.register("weed_bud",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HARVESTED_WEED = ITEMS.register("harvested_weed",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> JOINT = ITEMS.register("joint",
            () -> new Item(new Item.Properties().food(ModFoods.JOINT)));

    public static final RegistryObject<Item> WEED_SEEDS = ITEMS.register("weed_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WEED_CROP.get(), new Item.Properties()));

    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }
}
