/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package com.zhn.Remax.element.elements;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

@Element.ElementInfo(name="InvMove", description="Allows you to walk while in your Inventory, suggested by cityboss1.", category=Element.Catergoy.PLAYER, bind=0, value=false, dName="InvMove")
public class InvMove
extends Element {
    Integer[] keyBindingMove;
    Integer[] keyBindingLook;
    public static boolean active;

    public InvMove() {
        this.keyBindingMove = new Integer[]{this.mc.gameSettings.keyBindForward.getKeyCode(), this.mc.gameSettings.keyBindBack.getKeyCode(), this.mc.gameSettings.keyBindRight.getKeyCode(), this.mc.gameSettings.keyBindLeft.getKeyCode(), this.mc.gameSettings.keyBindJump.getKeyCode()};
        this.keyBindingLook = new Integer[]{200, 208, 205, 203};
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.getMinecraft();
            if (!(Minecraft.currentScreen instanceof GuiChat)) {
                Integer[] arrayOfInteger = this.keyBindingMove;
                int j = arrayOfInteger.length;
                int i = 0;
                while (i < j) {
                    Integer bindingMove = arrayOfInteger[i];
                    KeyBinding.setKeyBindState(bindingMove, Keyboard.isKeyDown((int)bindingMove));
                    ++i;
                }
                if (Minecraft.currentScreen != null) {
                    if (Keyboard.isKeyDown((int)this.keyBindingLook[0])) {
                        Minecraft.player.rotationPitch -= 3.0f;
                    }
                    if (Keyboard.isKeyDown((int)this.keyBindingLook[1])) {
                        Minecraft.player.rotationPitch += 3.0f;
                    }
                    if (Keyboard.isKeyDown((int)this.keyBindingLook[2])) {
                        Minecraft.player.rotationYaw += 3.0f;
                    }
                    if (Keyboard.isKeyDown((int)this.keyBindingLook[3])) {
                        Minecraft.player.rotationYaw -= 3.0f;
                    }
                }
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

