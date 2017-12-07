/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

@Element.ElementInfo(name="AutoTotem", description="Auto places a Totem of Undying in your offhand when needed.", category=Element.Catergoy.COMBAT, bind=0, value=false, dName="AutoTotem")
public class AutoTotem
extends Element {
    boolean moving = false;
    Minecraft mc = Minecraft.getMinecraft();
    int totems = 0;
    private int timer;
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            int i = 0;
            while (i < 45) {
                if (Minecraft.player.inventory.getStackInSlot(i).getItem().equals(Items.field_190929_cY)) {
                    ++this.totems;
                }
                ++i;
            }
            if (Minecraft.player.getHeldItemOffhand().getItem().equals(Items.field_190929_cY) || Minecraft.currentScreen instanceof GuiInventory) {
                return;
            }
            if (Minecraft.currentScreen instanceof GuiContainer && !(Minecraft.currentScreen instanceof InventoryEffectRenderer)) {
                return;
            }
            if (this.moving) {
                Minecraft.playerController.windowClick(0, 45, 0, ClickType.PICKUP, Minecraft.player);
                this.moving = false;
                return;
            }
            i = 0;
            while (i <= 35) {
                if (Minecraft.player.inventory.getStackInSlot(i).getItem().equals(Items.field_190929_cY)) {
                    if (i < 9) {
                        i += 36;
                    }
                    Minecraft.playerController.windowClick(0, i, 0, ClickType.PICKUP, Minecraft.player);
                    this.moving = true;
                    return;
                }
                ++i;
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        active = false;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        active = true;
    }

    @Override
    public String getValue() {
        return null;
    }
}

