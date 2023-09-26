package net.codificatorgm.testmod.item;

import net.codificatorgm.testmod.TestMod;
import net.codificatorgm.testmod.block.ModBlocks;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
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
    public static final RegistryObject<Item> PURPLE_HAZE_BUD = ITEMS.register("purple_haze_bud",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HARVESTED_WEED = ITEMS.register("harvested_weed",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HARVESTED_PURPLE_HAZE = ITEMS.register("harvested_purple_haze",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> JOINT = ITEMS.register("joint",
            () -> new Item(new Item.Properties().food(ModFoods.JOINT)));
    public static final RegistryObject<Item> PURPLE_HAZE_JOINT = ITEMS.register("purple_haze_joint",
            () -> new Item(new Item.Properties().food(ModFoods.PURPLE_HAZE_JOINT)));

    public static final RegistryObject<Item> BLUNT = ITEMS.register("blunt",
            () -> new Item(new Item.Properties().food(ModFoods.BLUNT)));

    public static final RegistryObject<Item> PURPLE_HAZE_BLUNT = ITEMS.register("purple_haze_blunt",
            () -> new Item(new Item.Properties().food(ModFoods.PURPLE_HAZE_BLUNT)));

    public static final RegistryObject<Item> CANNAMILK = ITEMS.register("cannamilk",
            () -> new CannaMilkItem(new Item.Properties().food(ModFoods.CANNAMILK)));

    public static final RegistryObject<Item> WEED_COOKIE = ITEMS.register("weed_cookie",
            () -> new Item(new Item.Properties().food(ModFoods.WEED_COOKIE)));

    public static final RegistryObject<Item> WEED_BROWNIE = ITEMS.register("weed_brownie",
            () -> new Item (new Item.Properties().food(ModFoods.WEED_BROWNIE)));

    public static final RegistryObject<Item> LEMON_SODA = ITEMS.register("lemon_soda",
            () -> new Item (new Item.Properties().food(ModFoods.LEMON_SODA)));

    public static final RegistryObject<Item> GRAPEFRUIT_SODA = ITEMS.register("grapefruit_soda",
            () -> new Item (new Item.Properties().food(ModFoods.GRAPEFRUIT_SODA)));

    public static final RegistryObject<Item> WEED_MUFFIN = ITEMS.register("weed_muffin",
            () -> new Item(new Item.Properties().food(ModFoods.WEED_MUFFIN)));
    public static final RegistryObject<Item> WEED_SEEDS = ITEMS.register("weed_seeds",
            () -> new ItemNameBlockItem(ModBlocks.WEED_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> SATIVA_SEEDS = ITEMS.register("sativa_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SATIVA_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> HAZE_SATIVA_SEEDS = ITEMS.register("haze_sativa_seeds",
            () -> new ItemNameBlockItem(ModBlocks.HAZE_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> PURPLE_HAZE_SEEDS = ITEMS.register("purple_haze_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PURPLE_HAZE_CROP.get(), new Item.Properties()));



    public static void register(IEventBus eventBus){

        ITEMS.register(eventBus);

    }

    public static class CannaMilkItem extends Item {
        public CannaMilkItem(Item.Properties builder) {
            super(builder);
        }
        public SoundEvent getDrinkingSoundLike() {
            return SoundEvents.GENERIC_DRINK;
        }
    }
}
