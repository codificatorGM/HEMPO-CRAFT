package net.codificatorgm.WeedOCraft.datagen;

import net.codificatorgm.WeedOCraft.TestMod;
import net.codificatorgm.WeedOCraft.block.ModBlocks;
import net.codificatorgm.WeedOCraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.JOINT);
        simpleItem(ModItems.BLUNT);
        simpleItem(ModItems.WEED_LEAF);
        simpleItem(ModItems.WEED_BUD);
        simpleItem(ModItems.WEED_SEEDS);
        simpleItem(ModItems.HARVESTED_WEED);
        simpleItem(ModItems.HARVESTED_PURPLE_HAZE);
        simpleItem(ModItems.PURPLE_HAZE_BUD);
        simpleItem(ModItems.PURPLE_HAZE_JOINT);
        simpleItem(ModItems.PURPLE_HAZE_SEEDS);
        simpleItem(ModItems.PURPLE_HAZE_BLUNT);
        simpleItem(ModItems.SATIVA_SEEDS);
        simpleItem(ModItems.HAZE_SATIVA_SEEDS);
        simpleItem(ModItems.CANNAMILK);
        simpleItem(ModItems.WEED_COOKIE);
        simpleItem(ModItems.WEED_MUFFIN);
        simpleItem(ModItems.WEED_BROWNIE);
        simpleItem(ModItems.GRAPEFRUIT_SODA);
        simpleItem(ModItems.LEMON_SODA);
        simpleItem(ModItems.BUBBLER);


        simpleBlockItem(ModBlocks.HEMP_DOOR);

        fenceItem(ModBlocks.HEMP_FENCE, ModBlocks.HEMP_BLOCK);
        buttonItem(ModBlocks.HEMP_BUTTON, ModBlocks.HEMP_BLOCK);


        evenSimplerBlockItem(ModBlocks.HEMP_STAIRS);
        evenSimplerBlockItem(ModBlocks.HEMP_SLAB);
        evenSimplerBlockItem(ModBlocks.HEMP_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.HEMP_FENCE_GATE);

        trapdoorItem(ModBlocks.HEMP_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(TestMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }



    public void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(TestMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(TestMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
