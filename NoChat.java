/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;

@Element.ElementInfo(name="NoChat", description="Removes every Chat Message 24/7 without hiding the actual chat size.", category=Element.Catergoy.RENDER, bind=0, value=false, dName="NoChat")
public class NoChat
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().clearChatMessages(true);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Minecraft.getMinecraft().ingameGUI.getChatGUI().clearChatMessages(false);
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

