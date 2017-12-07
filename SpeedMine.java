/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;

@Element.ElementInfo(name="SpeedMine", description="Allows you to mine 3x faster than normal.", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="SpeedMine")
public class SpeedMine
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
        	if (Minecraft.playerController.curBlockDamageMP > 0.7F)
            {
              Minecraft.getMinecraft();Minecraft.playerController.curBlockDamageMP = 1.0F;
            }
            Minecraft.getMinecraft();Minecraft.playerController.blockHitDelay = 0;
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

