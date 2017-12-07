/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import java.util.List;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;

@Element.ElementInfo(name="ESP", description="A simple GLOW ESP", category=Element.Catergoy.RENDER, bind=-22, value=false, dName="ESP \u00a77[Spectral]")
public class ESP
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.getMinecraft();
            Minecraft.getMinecraft();
            for (Object o : Minecraft.world.loadedEntityList) {
                if (!(o instanceof Entity)) continue;
                Entity e = (Entity)o;
                e.setGlowing(true);
            }
        }
    }

    @Override
    public void onDisable() {
        Minecraft.getMinecraft();
        Minecraft.getMinecraft();
        for (Object o : Minecraft.world.loadedEntityList) {
            if (!(o instanceof Entity)) continue;
            Entity e = (Entity)o;
            e.setGlowing(false);
        }
    }

    @Override
    public String getValue() {
        return null;
    }
}

