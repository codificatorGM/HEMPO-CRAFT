package net.codificatorgm.testmod.datagen;

import net.codificatorgm.testmod.TestMod;
import net.codificatorgm.testmod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, TestMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.WEED_LEAVES.get());
        this.tag(BlockTags.MINEABLE_WITH_AXE).add(ModBlocks.HEMP_BLOCK.get());

        this.tag(BlockTags.FENCES).add(ModBlocks.HEMP_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.HEMP_FENCE_GATE.get());



    }
}
