package net.codificatorgm.WeedOCraft.block.entity;

import net.codificatorgm.WeedOCraft.TestMod;

import net.codificatorgm.WeedOCraft.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TestMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<WeedMaticEntity>> WEEDMATIC =
            BLOCK_ENTITIES.register("weedmatic",
                    () -> BlockEntityType.Builder.of(WeedMaticEntity::new,
                            ModBlocks.WEEDMATIC.get()).build(null));

    public static final RegistryObject<BlockEntityType<RollingMachineEntity>> ROLLING_MACHINE =
            BLOCK_ENTITIES.register("rolling_machine",
                    () -> BlockEntityType.Builder.of(RollingMachineEntity::new,
                            ModBlocks.ROLLING_MACHINE.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
