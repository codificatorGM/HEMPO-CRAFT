package net.codificatorgm.WeedOCraft.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;


public class PurpleHazeJoint extends Item {
    public PurpleHazeJoint(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack item = pPlayer.getItemInHand(pUsedHand);
        if (pPlayer.getInventory().contains(new ItemStack(Items.FLINT_AND_STEEL))) {
            if (item.getDamageValue() == 3) {
                pPlayer.playSound(SoundEvents.FIRE_EXTINGUISH, 2, 2);
            } else if (item.getDamageValue() == 0) {
                pPlayer.playSound(SoundEvents.FLINTANDSTEEL_USE);
            } else {
                pPlayer.playSound(SoundEvents.HORSE_BREATHE);
            }


            pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer,
                    player -> player.broadcastBreakEvent(player.getUsedItemHand()));

            pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 380));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 200));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.ABSORPTION, 450));
            pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 450));


        } else {
            pPlayer.sendSystemMessage(Component.literal("You need a full Flint and Steel to light the Haze Joint!"));
        }
        return InteractionResultHolder.success(item);
    }
}