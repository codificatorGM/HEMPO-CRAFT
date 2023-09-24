package net.codificatorgm.testmod.datagen;

import net.codificatorgm.testmod.TestMod;
import net.codificatorgm.testmod.block.ModBlocks;
import net.codificatorgm.testmod.block.custom.WeedCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlocksStateProvider extends BlockStateProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.WEED_LEAVES);
        blockWithItem(ModBlocks.HEMP_BLOCK);

        makeWeedCrop((CropBlock) ModBlocks.WEED_CROP.get(), "weed_crop_stage", "weed_crop_stage");

        stairsBlock(((StairBlock) ModBlocks.HEMP_STAIRS.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.HEMP_SLAB.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.HEMP_BUTTON.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.HEMP_PRESSURE_PLATE.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.HEMP_FENCE.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.HEMP_FENCE_GATE.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.HEMP_DOOR.get()), modLoc("block/hemp_door_bottom"), modLoc("block/hemp_door_top"),"cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.HEMP_TRAPDOOR.get()), modLoc("block/hemp_trapdoor"),true,"cutout");

    }


    public void makeWeedCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> weedStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] weedStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((WeedCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MOD_ID, "block/" + textureName + state.getValue(((WeedCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }


    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }}
