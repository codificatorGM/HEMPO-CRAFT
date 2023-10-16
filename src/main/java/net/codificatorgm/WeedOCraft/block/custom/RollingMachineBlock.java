package net.codificatorgm.WeedOCraft.block.custom;

import net.codificatorgm.WeedOCraft.block.entity.ModBlockEntities;
import net.codificatorgm.WeedOCraft.block.entity.RollingMachineEntity;
import net.codificatorgm.WeedOCraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RollingMachineBlock extends Block implements EntityBlock {
    public static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 14.0D, 6.0D, 14.0D);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public RollingMachineBlock(Properties properties) {
        super(properties);
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return AABB;
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return ModBlockEntities.ROLLING_MACHINE.get().create(pos, state);

    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        player.playSound(SoundEvents.EXPERIENCE_ORB_PICKUP, 1f, 0.5f);

        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            BlockEntity be = level.getBlockEntity(pos);

            if (be instanceof RollingMachineEntity blockEntity) {
                ItemStack stack = player.getItemInHand(hand);
                @NotNull Item hempBud = ModItems.WEED_BUD.get();
                @NotNull Item paper = Items.PAPER;
                ItemStack hempBudStack = new ItemStack(ModItems.WEED_BUD.get());
                ItemStack paperStack = new ItemStack(Items.PAPER);
                @NotNull Item purpleBud = ModItems.PURPLE_HAZE_BUD.get();
                ItemStack purpleBudStack = new ItemStack(ModItems.PURPLE_HAZE_BUD.get());
                ItemStack weedLeafStack = new ItemStack(ModItems.WEED_LEAF.get());
                int paperSlot = player.getInventory().findSlotMatchingItem(paperStack);
                int hempBudSlot = player.getInventory().findSlotMatchingItem(hempBudStack);
                int purpleBudSlot = player.getInventory().findSlotMatchingItem(purpleBudStack);
                int weedLeafSlot = player.getInventory().findSlotMatchingItem(weedLeafStack);

                // Check for Purple Haze Bud & Weed Leaf
                if (player.getInventory().countItem(ModItems.PURPLE_HAZE_BUD.get()) >= 3 &&
                        player.getInventory().contains(new ItemStack(Items.PAPER)) && player.getInventory().contains(new ItemStack(ModItems.WEED_LEAF.get()))) {

                    if (stack.isEmpty()) {
                        player.getInventory().removeItem(purpleBudSlot, 3);
                        player.getInventory().removeItem(paperSlot, 1);
                        player.getInventory().removeItem(weedLeafSlot, 1);
                        player.setItemInHand(hand, new ItemStack(ModItems.PURPLE_HAZE_BLUNT.get()));
                        return InteractionResult.SUCCESS;
                    }
                }

                if (player.getInventory().countItem(ModItems.WEED_BUD.get()) >= 3 &&
                        player.getInventory().contains(new ItemStack(Items.PAPER)) && player.getInventory().contains(new ItemStack(ModItems.WEED_LEAF.get()))) {

                    if (stack.isEmpty()) {
                        player.getInventory().removeItem(hempBudSlot, 3);
                        player.getInventory().removeItem(paperSlot, 1);
                        player.getInventory().removeItem(weedLeafSlot, 1);
                        player.setItemInHand(hand, new ItemStack(ModItems.BLUNT.get()));
                        return InteractionResult.SUCCESS;
                    }
                }

                // Check for Weed Bud
                if (player.getInventory().countItem(hempBud) >= 3 &&
                        player.getInventory().countItem(paper) >= 1) {

                    if (stack.isEmpty()) {

                        player.getInventory().removeItem(hempBudSlot, 3);
                        player.getInventory().removeItem(paperSlot, 1);
                        player.setItemInHand(hand, new ItemStack(ModItems.JOINT.get()));
                        return InteractionResult.SUCCESS;
                    }
                }

                // Check for Purple Haze Bud
                if (player.getInventory().countItem(purpleBud) >= 3 &&
                        player.getInventory().contains(new ItemStack(Items.PAPER))) {

                    if (stack.isEmpty()) {
                        player.getInventory().removeItem(purpleBudSlot, 3);
                        player.getInventory().removeItem(paperSlot, 1);
                        player.setItemInHand(hand, new ItemStack(ModItems.PURPLE_HAZE_JOINT.get()));
                        return InteractionResult.SUCCESS;
                    }
                }
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}