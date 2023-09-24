package net.codificatorgm.testmod.datagen;

import net.codificatorgm.testmod.TestMod;
import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.JOINT);
        simpleItem(ModItems.WEED_LEAF);
        simpleItem(ModItems.WEED_BUD);
        simpleItem(ModItems.WEED_SEEDS);
        simpleItem(ModItems.HARVESTED_WEED);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(TestMod.MOD_ID,"item/" + item.getId().getPath()));
    }
}
