/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

@Element.ElementInfo(name="ElytraPlus", description="Forces you to go down, which will auto give you a boost.", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="Elytra")
public class ElytraPlus
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState() && Minecraft.player.isElytraFlying() && !Minecraft.player.onGround && !this.mc.gameSettings.keyBindJump.pressed) {
            Minecraft.player.motionX *= 1.02;
            Minecraft.player.motionZ *= 1.02;
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

