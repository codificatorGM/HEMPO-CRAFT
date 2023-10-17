package net.codificatorgm.WeedOCraft.datagen;

import net.codificatorgm.WeedOCraft.block.ModBlocks;
import net.codificatorgm.WeedOCraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.*;
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_COOKIE.get(), 4)
                .requires(ModItems.WEED_BUD.get(), 4)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.COOKIE, 4)
                .unlockedBy(getHasName(Items.COOKIE), has(Items.COOKIE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_BROWNIE.get(), 6)
                .requires(ModItems.WEED_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.COCOA_BEANS, 2)
                .unlockedBy(getHasName(Items.COCOA_BEANS), has(Items.COCOA_BEANS))
                .requires(Items.WHEAT, 2)
                .unlockedBy(getHasName(Items.WHEAT), has(Items.WHEAT))
                .requires(Items.EGG, 2)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.WEED_MUFFIN.get(), 3)
                .requires(ModItems.WEED_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.GOLDEN_CARROT, 2)
                .unlockedBy(getHasName(Items.GOLDEN_CARROT), has(Items.GOLDEN_CARROT))
                .requires(Items.EGG, 2)
                .unlockedBy(getHasName(Items.EGG), has(Items.EGG))
                .save(pWriter);

       ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.GRAPEFRUIT_SODA.get(), 1)
               .requires(ModItems.PURPLE_HAZE_BUD.get(), 3)
               .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
               .requires(Items.CHORUS_FRUIT, 2)
               .unlockedBy(getHasName(Items.CHORUS_FRUIT), has(Items.CHORUS_FRUIT))
               .requires(Items.GLASS_BOTTLE, 1)
               .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                .save(pWriter);


        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.LEMON_SODA.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 3)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.SLIME_BALL, 1)
                .unlockedBy(getHasName(Items.SLIME_BALL), has(Items.SLIME_BALL))
                .requires(Items.GLASS_BOTTLE, 1)
                .unlockedBy(getHasName(Items.GLASS_BOTTLE), has(Items.GLASS_BOTTLE))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CANNAMILK.get(), 1)
                .requires(ModItems.WEED_BUD.get(), 7)
                .unlockedBy(getHasName(ModItems.WEED_BUD.get()), has(ModItems.WEED_BUD.get()))
                .requires(Items.MILK_BUCKET, 1)
                .unlockedBy(getHasName(Items.PAPER), has(Items.PAPER))
                .requires(Items.NETHERITE_INGOT, 1)
                .unlockedBy(getHasName(Items.NETHERITE_INGOT), has(Items.NETHERITE_INGOT))
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

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.GRINDER.get(), 1)
                .requires(Items.IRON_INGOT, 1)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WEEDMATIC.get(), 1)
                .pattern("GIR")
                .pattern("WIR")
                .pattern("BIR")
                .define('I', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(Items.REDSTONE), has(Items.REDSTONE))
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .define('W', Items.GLASS)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                .define('B', Items.IRON_BLOCK)
                .unlockedBy(getHasName(Items.IRON_BLOCK), has(Items.IRON_BLOCK))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BUBBLER.get(), 1)
                .pattern("I ")
                .pattern("I ")
                .pattern("IR")
                .define('I', Items.GLASS)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                .define('R', Items.IRON_INGOT)
                .unlockedBy(getHasName(Items.IRON_INGOT), has(Items.IRON_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.GROWTH_LIGHT.get(), 2)
                .pattern("###")
                .pattern("WGW")
                .define('#', Items.COPPER_INGOT)
                .unlockedBy(getHasName(Items.COPPER_INGOT), has(Items.COPPER_INGOT))
                .define('W', Items.GLASS)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Items.GOLD_INGOT), has(Items.GOLD_INGOT))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PIPE.get(), 1)
                .pattern("AAG")
                .define('A', Items.AMETHYST_SHARD)
                .unlockedBy(getHasName(Items.AMETHYST_SHARD), has(Items.AMETHYST_SHARD))
                .define('G', Items.GLASS)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BONG.get(), 1)
                .pattern("R ")
                .pattern("YG")
                .pattern("# ")
                .define('R', Items.RED_STAINED_GLASS)
                .unlockedBy(getHasName(Items.RED_STAINED_GLASS), has(Items.RED_STAINED_GLASS))
                .define('Y', Items.YELLOW_STAINED_GLASS)
                .unlockedBy(getHasName(Items.YELLOW_STAINED_GLASS), has(Items.YELLOW_STAINED_GLASS))
                .define('#', Items.GREEN_STAINED_GLASS)
                .unlockedBy(getHasName(Items.GREEN_STAINED_GLASS), has(Items.GREEN_STAINED_GLASS))
                .define('G', Items.GLASS)
                .unlockedBy(getHasName(Items.GLASS), has(Items.GLASS))
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
