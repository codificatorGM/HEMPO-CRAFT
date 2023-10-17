package net.codificatorgm.WeedOCraft.block.custom;

import net.codificatorgm.WeedOCraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class PipeBlock extends HorizontalDirectionalBlock {
    public static final VoxelShape AABB = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public PipeBlock(Properties pProperties) {
        super(pProperties);
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
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack hempBud = new ItemStack(ModItems.WEED_BUD.get());
        ItemStack flint = new ItemStack(Items.FLINT_AND_STEEL);
        ItemStack purpleBud = new ItemStack(ModItems.PURPLE_HAZE_BUD.get());

        int hempBudSlot = pPlayer.getInventory().findSlotMatchingItem(hempBud);
        int purpleBudSlot = pPlayer.getInventory().findSlotMatchingItem(purpleBud);

        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        boolean cond1 = pPlayer.getInventory().contains(hempBud);
        boolean cond2 = pPlayer.getInventory().contains(purpleBud);
        boolean hasFlint = pPlayer.getInventory().contains(flint);

        if (!cond1 && !cond2) {
            pPlayer.sendSystemMessage(Component.literal("You need a Hemp bud or Purple hemp Bud!"));
        } else if (!hasFlint) {
            pPlayer.sendSystemMessage(Component.literal("You need a full Flint and Steel to light the Blunt!"));
        }
        if (cond1 && hasFlint) {
            pPlayer.getInventory().removeItem(hempBudSlot, 1);

            pPlayer.playSound(SoundEvents.BUBBLE_COLUMN_UPWARDS_INSIDE, 1, 0.4f);

            pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 380));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER, 380));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 400));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400));

        } else if (cond2 && hasFlint) {
            pPlayer.getInventory().removeItem(purpleBudSlot, 1);

            pPlayer.playSound(SoundEvents.BUBBLE_COLUMN_UPWARDS_INSIDE, 1, 0.4f);

            pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 380));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 200, 2));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 400));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200));

        }
        return InteractionResultHolder.success(item);

    }
}