package net.codificatorgm.testmod.datagen.loot;

import net.codificatorgm.testmod.block.ModBlocks;
import net.codificatorgm.testmod.block.custom.PurpleHazeCropBlock;
import net.codificatorgm.testmod.block.custom.SativaCropBlock;
import net.codificatorgm.testmod.block.custom.WeedCropBlock;
import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StemBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.BinomialDistributionGenerator;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;
import java.util.function.Function;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    public LootTable.Builder createLikeStemDropsTwoItems(Block pBlock, Item pItem, Item pItem2) {
        return LootTable.lootTable()
                .withPool(this.applyExplosionDecay(pBlock,
                        LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(pItem)
                                        .apply(StemBlock.AGE.getPossibleValues(), (p_249795_) -> {
                                            return SetItemCountFunction.setCount(
                                                    BinomialDistributionGenerator.binomial(3, (float) (p_249795_ + 1) / 15.0F)
                                            ).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock)
                                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                                            .hasProperty(StemBlock.AGE, p_249795_))
                                            );
                                        })
                                )
                                .add(LootItem.lootTableItem(pItem2)
                                        .apply(StemBlock.AGE.getPossibleValues(), (p_249795_) -> {
                                            return SetItemCountFunction.setCount(
                                                    BinomialDistributionGenerator.binomial(3, (float) (p_249795_ + 1) / 15.0F)
                                            ).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(pBlock)
                                                    .setProperties(StatePropertiesPredicate.Builder.properties()
                                                            .hasProperty(StemBlock.AGE, p_249795_))
                                            );
                                        })
                                )
                ));
    }

    @Override
    protected void generate() {

        this.add(ModBlocks.WEED_LEAVES.get(),
                block -> createLikeSilkTouchOrShearsDispatchTable(ModBlocks.WEED_LEAVES.get()
                        , LootItem.lootTableItem(ModItems.WEED_LEAF.get())
                                .apply(SetItemCountFunction
                                        .setCount(UniformGenerator
                                                .between(1.0F, 3.0F)))));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.WEED_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WeedCropBlock.AGE, 5));
        this.add(ModBlocks.WEED_CROP.get(), createCropDrops(ModBlocks.WEED_CROP.get(), ModItems.HARVESTED_WEED.get(),
                ModItems.WEED_SEEDS.get(), lootitemcondition$builder));

        LootItemCondition.Builder lootitemcondition$builders = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.PURPLE_HAZE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PurpleHazeCropBlock.AGE, 5));
        this.add(ModBlocks.PURPLE_HAZE_CROP.get(), createCropDrops(ModBlocks.PURPLE_HAZE_CROP.get(), ModItems.HARVESTED_PURPLE_HAZE.get(),
                ModItems.PURPLE_HAZE_SEEDS.get(), lootitemcondition$builders));

        LootItemCondition.Builder lootitemcondition$builder2 = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.SATIVA_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SativaCropBlock.AGE, 7));

        this.add(ModBlocks.SATIVA_CROP.get(),
                block -> createLikeStemDropsTwoItems(ModBlocks.SATIVA_CROP.get()
                        , ModItems.HARVESTED_WEED.get(), ModItems.WEED_LEAF.get())
                        .apply(SetItemCountFunction
                                .setCount(UniformGenerator
                                        .between(1.0F, 3.0F)).when(lootitemcondition$builder2)));

        this.add(ModBlocks.HAZE_CROP.get(),
                block -> createLikeStemDropsTwoItems(ModBlocks.HAZE_CROP.get()
                        , ModItems.HARVESTED_PURPLE_HAZE.get(), ModItems.WEED_LEAF.get())
                        .apply(SetItemCountFunction
                                .setCount(UniformGenerator
                                        .between(1.0F, 3.0F)).when(lootitemcondition$builder2)));


        this.dropSelf(ModBlocks.HEMP_BLOCK.get());
        this.dropSelf(ModBlocks.HEMP_FENCE.get());
        this.dropSelf(ModBlocks.HEMP_STAIRS.get());
        this.dropSelf(ModBlocks.HEMP_BUTTON.get());
        this.dropSelf(ModBlocks.HEMP_FENCE.get());
        this.dropSelf(ModBlocks.HEMP_FENCE_GATE.get());
        this.dropSelf(ModBlocks.HEMP_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.HEMP_TRAPDOOR.get());
        this.dropSelf(ModBlocks.GRINDER.get());

        this.add(ModBlocks.PIPE.get(),
                block -> createSilkTouchOnlyTable(ModBlocks.PIPE.get()));

        this.add(ModBlocks.GROWTH_LIGHT.get(),
                block -> createSilkTouchOnlyTable(ModBlocks.GROWTH_LIGHT.get()));

        this.add(ModBlocks.BONG.get(),
                block -> createSilkTouchOnlyTable(ModBlocks.BONG.get()));


        this.add(ModBlocks.HEMP_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.HEMP_SLAB.get()));
        this.add(ModBlocks.HEMP_DOOR.get(),
                block -> createDoorTable(ModBlocks.HEMP_DOOR.get()));


    }

    protected static LootTable.Builder createLikeSilkTouchOrShearsDispatchTable(Block pBlock, LootPoolEntryContainer.Builder<?> pBuilder) {
        return createSelfDropDispatchTable(pBlock, HAS_SHEARS.or(HAS_SILK_TOUCH), pBuilder);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
