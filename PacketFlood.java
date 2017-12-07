/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

@Element.ElementInfo(name="PacketFlood", description="Flood's the server with packets.", bind=0, category=Element.Catergoy.MISC, value=true, dName="PacketFlood \u00a77[Vanilla]")
public class PacketFlood
extends Element {
    int timer;

    @EventTarget
    public void onUpdate(EventUpdate e) {
        if (this.getState()) {
            int i = 0;
            while (i < 10000) {
                if (this.timer >= 0) {
                    Minecraft.player.posY -= 2.09;
                    this.timer = 0;
                }
                ++i;
            }
        }
    }

    @Override
    public String getValue() {
        return "Vanilla";
    }
}

