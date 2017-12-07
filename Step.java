/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

@Element.ElementInfo(name="Step", description="Vanilla step", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="Step \u00a77[Vanilla]")
public class Step
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.getMinecraft();
            Minecraft.player.stepHeight = 1.0f;
        }
    }

    @Override
    public void onDisable() {
        Minecraft.getMinecraft();
        Minecraft.player.stepHeight = 0.6f;
    }

    @Override
    public String getValue() {
        return null;
    }
}

