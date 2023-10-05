package net.codificatorgm.WeedOCraft.tab;

import net.codificatorgm.WeedOCraft.TestMod;
import net.codificatorgm.WeedOCraft.block.ModBlocks;
import net.codificatorgm.WeedOCraft.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MOD_ID);


    public static final RegistryObject<CreativeModeTab> MOD_TABS = CREATIVE_MODE_TABS.register("test_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.WEED_LEAF.get()))
                    .title(Component.translatable("creativetab.test_tab"))
                    .displayItems((pParameters, event) -> {
                        event.accept(ModItems.WEED_LEAF.get());
                        event.accept(ModBlocks.WEED_LEAVES.get());
                        event.accept(ModItems.WEED_SEEDS.get());
                        event.accept(ModItems.WEED_BUD.get());
                        event.accept(ModItems.HARVESTED_WEED.get());
                        event.accept(ModItems.PURPLE_HAZE_SEEDS.get());
                        event.accept(ModItems.PURPLE_HAZE_BUD.get());
                        event.accept(ModItems.HARVESTED_PURPLE_HAZE.get());
                        event.accept(ModItems.SATIVA_SEEDS.get());
                        event.accept(ModItems.HAZE_SATIVA_SEEDS.get());
                        event.accept(ModItems.LEMON_SODA.get());
                        event.accept(ModItems.GRAPEFRUIT_SODA.get());
                        event.accept(ModItems.JOINT.get());
                        event.accept(ModItems.PURPLE_HAZE_JOINT.get());
                        event.accept(ModItems.BLUNT.get());
                        event.accept(ModItems.PURPLE_HAZE_BLUNT.get());
                        event.accept(ModItems.CANNAMILK.get());
                        event.accept(ModItems.WEED_COOKIE.get());
                        event.accept(ModItems.WEED_MUFFIN.get());
                        event.accept(ModItems.WEED_BROWNIE.get());
                        event.accept(ModItems.COOKED_EGG.get());
                        event.accept(ModBlocks.HEMP_BLOCK.get());
                        event.accept(ModBlocks.HEMP_STAIRS.get());
                        event.accept(ModBlocks.HEMP_BUTTON.get());
                        event.accept(ModBlocks.HEMP_FENCE.get());
                        event.accept(ModBlocks.HEMP_DOOR.get());
                        event.accept(ModBlocks.HEMP_SLAB.get());
                        event.accept(ModBlocks.HEMP_TRAPDOOR.get());
                        event.accept(ModBlocks.HEMP_PRESSURE_PLATE.get());
                        event.accept(ModBlocks.HEMP_FENCE_GATE.get());
                        event.accept(ModBlocks.BONG.get());
                        event.accept(ModBlocks.GROWTH_LIGHT.get());
                        event.accept(ModBlocks.GRINDER.get());
                        event.accept(ModBlocks.PIPE.get());
                        event.accept(ModBlocks.WEEDMATIC.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {

        CREATIVE_MODE_TABS.register(eventBus);

    }


}
