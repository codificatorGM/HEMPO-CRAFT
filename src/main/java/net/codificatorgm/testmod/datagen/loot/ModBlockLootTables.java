package net.codificatorgm.testmod.datagen.loot;

import net.codificatorgm.testmod.block.ModBlocks;
import net.codificatorgm.testmod.block.custom.WeedCropBlock;
import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {

        this.add(ModBlocks.WEED_BLOCK.get(),
                block -> createLikeSilkTouchOrShearsDispatchTable(ModBlocks.WEED_BLOCK.get()
                ,LootItem.lootTableItem(ModItems.WEED_LEAF.get()).apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 3.0F)))));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.WEED_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(WeedCropBlock.AGE, 5));

            this.add(ModBlocks.WEED_CROP.get(), createCropDrops(ModBlocks.WEED_CROP.get(), ModItems.HARVESTED_WEED.get() ,
                ModItems.WEED_SEEDS.get(), lootitemcondition$builder));

    }
    protected LootTable.Builder createCropDropsLike(Block pCropBlock, Item pGrownCropItem, Item pSeedsItem, LootItemCondition.Builder pDropGrownCropCondition) {
        return this.applyExplosionDecay(pCropBlock, LootTable.lootTable().withPool(LootPool.lootPool().add(LootItem.lootTableItem(pGrownCropItem).when(pDropGrownCropCondition).otherwise(LootItem.lootTableItem(pSeedsItem)))).withPool(LootPool.lootPool().when(pDropGrownCropCondition).add(LootItem.lootTableItem(pSeedsItem).apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3)))));
    }
    protected static LootTable.Builder createLikeSilkTouchOrShearsDispatchTable(Block pBlock, LootPoolEntryContainer.Builder<?> pBuilder) {
        return createSelfDropDispatchTable(pBlock, HAS_SHEARS.or(HAS_SILK_TOUCH), pBuilder);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
