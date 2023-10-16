package net.codificatorgm.WeedOCraft.datagen;

import net.codificatorgm.WeedOCraft.TestMod;
import net.codificatorgm.WeedOCraft.block.ModBlocks;
import net.codificatorgm.WeedOCraft.block.custom.*;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlocksStateProvider extends BlockStateProvider implements DataProvider {
    public ModBlocksStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TestMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.WEED_LEAVES);
        blockWithItem(ModBlocks.HEMP_BLOCK);

        makeWeedCrop((CropBlock) ModBlocks.WEED_CROP.get(), "weed_crop_stage", "weed_crop_stage");
        makePurpleHazeCrop((CropBlock) ModBlocks.PURPLE_HAZE_CROP.get(), "purple_haze_crop_stage", "purple_haze_crop_stage");
        makeSativaCrop((CropBlock) ModBlocks.SATIVA_CROP.get(), "sativa_crop_stage", "sativa_crop_stage");
        makeHazeCrop((CropBlock) ModBlocks.HAZE_CROP.get(), "haze_sativa_stage", "haze_sativa_stage");

        stairsBlock(((StairBlock) ModBlocks.HEMP_STAIRS.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.HEMP_SLAB.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        buttonBlock(((ButtonBlock) ModBlocks.HEMP_BUTTON.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.HEMP_PRESSURE_PLATE.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.HEMP_FENCE.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.HEMP_FENCE_GATE.get()), blockTexture(ModBlocks.HEMP_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.HEMP_DOOR.get()), modLoc("block/hemp_door_bottom"), modLoc("block/hemp_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.HEMP_TRAPDOOR.get()), modLoc("block/hemp_trapdoor"), true, "cutout");
        blockWithItem(ModBlocks.BONG);
        blockWithItem(ModBlocks.GROWTH_LIGHT);
        blockWithItem(ModBlocks.PIPE);

    }


    public void makeWeedCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> weedStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    public void makePurpleHazeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> purpleHazeStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }


    private ConfiguredModel[] purpleHazeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((PurpleHazeCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MOD_ID, "block/" + textureName + state.getValue(((PurpleHazeCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private ConfiguredModel[] weedStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((WeedCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MOD_ID, "block/" + textureName + state.getValue(((WeedCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    public void makeSativaCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> sativaStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] sativaStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((SativaCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MOD_ID, "block/" + textureName + state.getValue(((SativaCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    public void makeHazeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> hazeStates(state, block, modelName, textureName);
        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] hazeStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((HazeSativaCropBlock) block).getAgeProperty()),
                new ResourceLocation(TestMod.MOD_ID, "block/" + textureName + state.getValue(((HazeSativaCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
