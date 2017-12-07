/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

@Element.ElementInfo(name="AutoWalk", description="Holds down your walk key at all times, suggested by cityboss1.", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="AutoWalk")
public class AutoWalk
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            this.mc.gameSettings.keyBindForward.pressed = true;
            if (Minecraft.currentScreen != null || Minecraft.currentScreen instanceof GuiChat) {
                this.mc.gameSettings.keyBindForward.pressed = true;
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.mc.gameSettings.keyBindForward.pressed = false;
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

