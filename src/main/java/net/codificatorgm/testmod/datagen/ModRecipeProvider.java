package net.codificatorgm.testmod.datagen;

import net.codificatorgm.testmod.block.ModBlocks;
import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WEED_LEAVES.get(), 4)
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.WEED_LEAF.get())
                .unlockedBy(getHasName(ModItems.WEED_LEAF.get()), has(ModItems.WEED_LEAF.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK, 4)
                .pattern("S  ")
                .pattern("S  ")
                .define('S', ModBlocks.HEMP_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.JOINT.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.PAPER, 1)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURPLE_HAZE_JOINT.get(), 1)
                .requires(ModItems.PURPLE_HAZE_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.PURPLE_HAZE_BUD.get()), has(ModItems.PURPLE_HAZE_BUD.get()))
                .requires(Items.PAPER, 1)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLUNT.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.PAPER, 1)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .requires(ModItems.WEED_LEAF.get(), 1)
                .unlockedBy(getHasName(ModItems.WEED_LEAF.get()), has(ModItems.WEED_LEAF.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURPLE_HAZE_BLUNT.get(), 1)
                .requires(ModItems.PURPLE_HAZE_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.PURPLE_HAZE_BUD.get()), has(ModItems.PURPLE_HAZE_BUD.get()))
                .requires(Items.PAPER, 1)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .requires(ModItems.WEED_LEAF.get(), 1)
                .unlockedBy(getHasName(ModItems.WEED_LEAF.get()), has(ModItems.WEED_LEAF.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.HEMP_BLOCK.get(), 9)
                .requires(ModItems.WEED_LEAF.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_LEAF.get()), has(ModItems.WEED_LEAF.get()))
                .requires(ModBlocks.WEED_LEAVES.get(), 2)
                .unlockedBy(getHasName(ModBlocks.WEED_LEAVES.get()), has(ModBlocks.WEED_LEAVES.get()))
                .requires(Items.SLIME_BALL, 1)
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_LEAF.get(), 64)
                .requires(ModItems.HARVESTED_WEED.get(), 5)
                .unlockedBy(getHasName(ModItems.HARVESTED_WEED.get()), has(ModItems.HARVESTED_WEED.get()))
                .requires(Items.SHEARS, 1)
                .unlockedBy(getHasName(Items.SHEARS), has(Items.SHEARS))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_SEEDS.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 1)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURPLE_HAZE_SEEDS.get(), 1)
                .requires(ModItems.PURPLE_HAZE_BUD.get(), 1)
                .unlockedBy(getHasName(ModItems.PURPLE_HAZE_BUD.get()), has(ModItems.PURPLE_HAZE_BUD.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_BUD.get(), 4)
                .requires(ModItems.HARVESTED_WEED.get(), 1)
                .unlockedBy(getHasName(ModItems.HARVESTED_WEED.get()), has(ModItems.HARVESTED_WEED.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PURPLE_HAZE_BUD.get(), 4)
                .requires(ModItems.HARVESTED_PURPLE_HAZE.get(), 1)
                .unlockedBy(getHasName(ModItems.HARVESTED_PURPLE_HAZE.get()), has(ModItems.HARVESTED_PURPLE_HAZE.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEMP_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModBlocks.HEMP_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.HEMP_STAIRS.get(), 4)
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModBlocks.HEMP_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HEMP_TRAPDOOR.get(), 2)
                .pattern("###").pattern("###")
                .define('#', ModBlocks.HEMP_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HEMP_PRESSURE_PLATE.get())
                .define('#', ModBlocks.HEMP_BLOCK.get())
                .pattern("##")
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HEMP_FENCE_GATE.get())
                .define('#', Items.STICK).define('W', ModBlocks.HEMP_BLOCK.get())
                .pattern("#W#")
                .pattern("#W#")
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);


        //fence
        int i = ModBlocks.HEMP_FENCE.get() == Blocks.NETHER_BRICK_FENCE ? 6 : 3;
        Item item = ModBlocks.HEMP_FENCE.get() == Blocks.NETHER_BRICK_FENCE ? Items.NETHER_BRICK : Items.STICK;
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.HEMP_FENCE.get(), i)
                .define('W', ModBlocks.HEMP_BLOCK.get())
                .define('#', item)
                .pattern("W#W")
                .pattern("W#W")
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.HEMP_DOOR.get(), 3)
                .define('#', ModBlocks.HEMP_BLOCK.get())
                .pattern("##").pattern("##")
                .pattern("##")
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.HEMP_BUTTON.get())
                .requires(ModBlocks.HEMP_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.HEMP_BLOCK.get()), has(ModBlocks.HEMP_BLOCK.get()))
                .save(pWriter);

    }
}
