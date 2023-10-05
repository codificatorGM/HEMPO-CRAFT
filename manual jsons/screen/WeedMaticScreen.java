package net.codificatorgm.WeedOCraft.screen;

import net.minecraft.client.gui.screens.recipebook.AbstractFurnaceRecipeBookComponent;
import net.minecraft.client.gui.screens.recipebook.BlastingRecipeBookComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.BlastFurnaceMenu;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WeedMaticScreen extends AbstractCustomScreen<WeedMaticMenu> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("textures/gui/container/weedmatic_gui.png");

    public WeedMaticScreen(WeedMaticMenu pMenu, AbstractFurnaceRecipeBookComponent pRecipeBookComponent, Inventory pPlayerInventory, Component pTitle, ResourceLocation pTexture) {
        super(pMenu, pRecipeBookComponent, pPlayerInventory, pTitle, TEXTURE);
    }
}