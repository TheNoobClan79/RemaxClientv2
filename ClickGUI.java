/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package com.zhn.Remax.element.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;
import com.zhn.Remax.gui.click.ClickGui;

@Element.ElementInfo(name="", description="", category=Element.Catergoy.GUI, bind=54, value=false, dName="")
public class ClickGUI
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (Keyboard.isKeyDown((int)54) && !(Minecraft.currentScreen instanceof GuiChat)) {
            this.mc.displayGuiScreen(new ClickGui());
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public String getValue() {
        return null;
    }
}

