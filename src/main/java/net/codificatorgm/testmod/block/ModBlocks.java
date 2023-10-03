

package net.codificatorgm.testmod.block;

import net.codificatorgm.testmod.TestMod;
import net.codificatorgm.testmod.block.custom.*;
import net.codificatorgm.testmod.block.custom.LightBlock;
import net.codificatorgm.testmod.block.custom.PipeBlock;
import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
           DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod.MOD_ID);

    public static final RegistryObject<Block> WEED_LEAVES = registerBlock("weed_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.PLANT).strength(0.2F)
                    .randomTicks().sound(SoundType.GRASS).noOcclusion()
                    .ignitedByLava().pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> BONG = registerBlock("bong",
            () -> new BongBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.CHAIN)));

    public static final RegistryObject<Block> GRINDER = registerBlock("grinder",
            () -> new GrinderBlock(BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD).sound(SoundType.STONE)));

    public static final RegistryObject<Block> PIPE = registerBlock("pipe",
            () -> new PipeBlock(BlockBehaviour.Properties.copy(Blocks.LARGE_AMETHYST_BUD)));

    public static final RegistryObject<Block> WEEDMATIC = registerBlock("weedmatic",
            () -> new WeedMaticBlock(BlockBehaviour.Properties.copy(Blocks.ANVIL)));
    public static final RegistryObject<Block> GROWTH_LIGHT = registerBlock("growth_light",
            () -> new LightBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).sound(SoundType.GLASS)
                    .lightLevel((value -> 15))
                    .noOcclusion()));

    public static final RegistryObject<Block> WEED_CROP = BLOCKS.register("weed_crop",
            () -> new WeedCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> SATIVA_CROP = BLOCKS.register("sativa_crop",
            () -> new SativaCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));

    public static final RegistryObject<Block> HAZE_CROP = BLOCKS.register("haze_crop",
            () -> new HazeSativaCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));

    public static final RegistryObject<Block> PURPLE_HAZE_CROP = BLOCKS.register("purple_haze_crop",
            () -> new PurpleHazeCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));

    public static final RegistryObject<Block> HEMP_BLOCK = registerBlock("hemp_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)
                    .ignitedByLava()
                    ));

    public static final RegistryObject<Block> HEMP_STAIRS = registerBlock("hemp_stairs",
            () -> new StairBlock(() -> ModBlocks.HEMP_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)
                            .ignitedByLava()));
    public static final RegistryObject<Block> HEMP_SLAB = registerBlock("hemp_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)
                    .ignitedByLava()));

    public static final RegistryObject<Block> HEMP_BUTTON = registerBlock("hemp_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_BUTTON),
                    BlockSetType.BIRCH, 10, true));
    public static final RegistryObject<Block> HEMP_PRESSURE_PLATE = registerBlock("hemp_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS),
                    BlockSetType.BIRCH));
    public static final RegistryObject<Block> HEMP_FENCE = registerBlock("hemp_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS)
                    .ignitedByLava()));
    public static final RegistryObject<Block> HEMP_FENCE_GATE = registerBlock("hemp_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).ignitedByLava()
                    , SoundEvents.BAMBOO_WOOD_FENCE_GATE_OPEN,
                    SoundEvents.BAMBOO_WOOD_FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> HEMP_DOOR = registerBlock("hemp_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion().ignitedByLava(), BlockSetType.BIRCH));

    public static final RegistryObject<Block> HEMP_TRAPDOOR = registerBlock("hemp_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_PLANKS).noOcclusion().ignitedByLava(), BlockSetType.BIRCH));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
