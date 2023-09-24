package net.codificatorgm.testmod.datagen;

import net.codificatorgm.testmod.block.ModBlocks;
import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WEED_BLOCK.get(), 4)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.WEED_LEAF.get())
                .unlockedBy(getHasName(ModItems.WEED_LEAF.get()), has(ModItems.WEED_LEAF.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JOINT.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.PAPER, 1)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_SEEDS.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 1)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_BUD.get(), 4)
                .requires(ModItems.HARVESTED_WEED.get(), 1)
                .unlockedBy(getHasName(ModItems.HARVESTED_WEED.get()), has(ModItems.HARVESTED_WEED.get()))
                .save(pWriter);
    }
}
