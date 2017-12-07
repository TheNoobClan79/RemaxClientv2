/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

@Element.ElementInfo(name="Sprint", description="Makes you sprint automically.", category=Element.Catergoy.PLAYER, bind=0, value=false, dName="Sprint")
public class Sprint
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.player.setSprinting(true);
            if (!Minecraft.player.isDead) {
                Minecraft.player.setSprinting(true);
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

