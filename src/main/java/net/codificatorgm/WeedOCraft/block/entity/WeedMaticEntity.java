package net.codificatorgm.WeedOCraft.block.entity;

import net.codificatorgm.WeedOCraft.TestMod;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;

public class WeedMaticEntity extends BlockEntity {
    private final ItemStackHandler inventory = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            WeedMaticEntity.this.setChanged();
        }
    };
    private LazyOptional<IItemHandler> optional = LazyOptional.of(() -> this.inventory);

    public WeedMaticEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.WEEDMATIC.get(), pos, state);
    }

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        CompoundTag testmodData = nbt.getCompound(TestMod.MOD_ID);
        this.inventory.deserializeNBT(testmodData.getCompound("Inventory"));
    }

    @Override
    protected void saveAdditional(CompoundTag nbt) {
        super.saveAdditional(nbt);
        var testmodData = new CompoundTag();
        testmodData.put("Inventory", this.inventory.serializeNBT());
        nbt.put(TestMod.MOD_ID, testmodData);

    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return this.optional.cast();
        }
        return super.getCapability(cap);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        this.optional.invalidate();
    }


    public ItemStackHandler getInventory(){
        return this.inventory;
    }

  public ItemStack getItem(){
        return this.inventory.getStackInSlot(0);
  }

  public void setItem(ItemStack stack){
        this.inventory.setStackInSlot(0, stack);
  }
}

