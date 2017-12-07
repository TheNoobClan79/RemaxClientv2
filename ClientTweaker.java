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
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.recipebook.GuiRecipeBook;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

@Element.ElementInfo(name="ClientTweaker", description="Tries to fix serveal Client Glitches", category=Element.Catergoy.MISC, bind=0, value=false, dName="ClientTweaker")
public class ClientTweaker
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            GuiRecipeBook guiRecipeBook = new GuiRecipeBook();
            if (this.mc.gameSettings.keyBindInventory.pressed) {
                this.mc.gameSettings.keyBindInventory.pressed = false;
                this.mc.displayGuiScreen(new GuiContainerCreative(Minecraft.player));
            }
        }
    }

    @Override
    public String getValue() {
        return null;
    }
}

