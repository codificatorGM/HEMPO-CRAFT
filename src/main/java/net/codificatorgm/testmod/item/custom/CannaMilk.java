package net.codificatorgm.testmod.item.custom;

import net.codificatorgm.testmod.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;


public class CannaMilk extends Item {
    public CannaMilk(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {

        ItemStack item = pPlayer.getItemInHand(pUsedHand);

            pPlayer.playSound(SoundEvents.GENERIC_DRINK, 2,0.8f);



        pPlayer.getItemInHand(pUsedHand).hurtAndBreak(1, pPlayer,
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));
        pPlayer.getItemInHand(pUsedHand).hurtAndBreak(0, pPlayer,
                player -> player.curePotionEffects(new ItemStack(ModItems.CANNAMILK.get())));

        pPlayer.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 400, 3));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.HUNGER, 400, 3));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 900, 1));
        pPlayer.addEffect(new MobEffectInstance(MobEffects.HEAL, 5, 3));

        return InteractionResultHolder.success(item);
    }

}
