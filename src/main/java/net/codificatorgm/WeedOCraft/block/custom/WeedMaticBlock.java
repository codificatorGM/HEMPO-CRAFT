package net.codificatorgm.WeedOCraft.block.custom;

import net.codificatorgm.WeedOCraft.block.entity.ModBlockEntities;
import net.codificatorgm.WeedOCraft.block.entity.WeedMaticEntity;
import net.codificatorgm.WeedOCraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
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
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WeedMaticBlock extends Block implements EntityBlock {
    public static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 14.0D, 32.0D, 14.0D);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public WeedMaticBlock(Properties properties) {
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
        return ModBlockEntities.WEEDMATIC.get().create(pos, state);
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult hitResult) {
        player.playSound(SoundEvents.ENDER_CHEST_OPEN, 0.05f, 1.1f);
        if (!level.isClientSide() && hand == InteractionHand.MAIN_HAND) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof WeedMaticEntity blockEntity) {
                ItemStack stack = player.getItemInHand(hand);
                ItemStackHandler inventory = blockEntity.getInventory();

                if (stack.isEmpty() || (stack.is(ModItems.WEED_LEAF.get()) || stack.is(ModItems.JOINT.get())
                        || stack.is(ModItems.WEED_BUD.get()) || stack.is(ModItems.PURPLE_HAZE_BUD.get())
                        || stack.is(ModItems.HARVESTED_WEED.get()) || stack.is(ModItems.HARVESTED_PURPLE_HAZE.get())
                        || stack.is(ModItems.PURPLE_HAZE_JOINT.get()) || stack.is(ModItems.BLUNT.get())
                        || stack.is(ModItems.PURPLE_HAZE_BLUNT.get()) || stack.is(ModItems.CANNAMILK.get())
                        || stack.is(ModItems.WEED_COOKIE.get()) || stack.is(ModItems.WEED_BROWNIE.get())
                        || stack.is(ModItems.LEMON_SODA.get()) || stack.is(ModItems.GRAPEFRUIT_SODA.get())
                        || stack.is(ModItems.WEED_MUFFIN.get()) || stack.is(ModItems.WEED_SEEDS.get())
                        || stack.is(ModItems.SATIVA_SEEDS.get()) || stack.is(ModItems.HAZE_SATIVA_SEEDS.get())
                        || stack.is(ModItems.PURPLE_HAZE_SEEDS.get()))) {

                    if (!stack.isEmpty() && !inventory.getStackInSlot(0).is(stack.getItem())) {
                        if (inventory.getStackInSlot(0).getCount() > 0)

                            player.sendSystemMessage(Component.literal("The WeedBar is already storing an item!"));
                    }

                    if (stack.isEmpty()) {
                        // Get the item from the block entity and give it to the player
                        if (inventory.getStackInSlot(0).isEmpty()) {
                            player.sendSystemMessage(Component.literal("The WeedBar is Empty!"));
                            return InteractionResult.SUCCESS;
                        }
                        ItemStack extracted = inventory.extractItem(0, player.isCrouching() ? inventory.getSlotLimit(0) : 1, false);
                        player.setItemInHand(hand, extracted);

                    } else if (!stack.isEmpty()) {
                        // Set the item in the block entity to the item in the player's hand (assuming the blockentity can store the item)
                        ItemStack toInsert = stack.copy();
                        toInsert.setCount(1);

                        ItemStack leftover = inventory.insertItem(0, toInsert, false);

                        ItemStack remainder = stack.copy();
                        remainder.setCount(remainder.getCount() - 1);
                        remainder.grow(leftover.getCount());
                        player.setItemInHand(hand, remainder);
                    }
                    return InteractionResult.SUCCESS;

                } else {
                    player.sendSystemMessage(Component.literal("The WeedBar is not suitable for this!"));
                }
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }

    @Override
    public void onRemove(@NotNull BlockState state, @NotNull Level level, @NotNull BlockPos pos, @NotNull BlockState newState, boolean isMoving) {
        if (!level.isClientSide()) {
            BlockEntity be = level.getBlockEntity(pos);
            if (be instanceof WeedMaticEntity blockEntity) {
                ItemStackHandler inventory = blockEntity.getInventory();
                for (int index = 0; index < inventory.getSlots(); index++) {
                    ItemStack stack = inventory.getStackInSlot(index);
                    var entity = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, stack);
                    level.addFreshEntity(entity);
                }
            }
        }

        super.onRemove(state, level, pos, newState, isMoving);
    }
}