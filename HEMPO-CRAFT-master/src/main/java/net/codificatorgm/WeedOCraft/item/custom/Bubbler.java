package net.codificatorgm.WeedOCraft.item.custom;

import net.codificatorgm.WeedOCraft.item.ModItems;
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


public class Bubbler extends Item {
    public Bubbler(Properties pProperties) {
        super(pProperties);
    }

    @Override
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