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
import net.minecraft.inventory.InventoryEnderChest;

@Element.ElementInfo(name="SmoothMC", description="Makes your Minecraft run a lot smoother.", category=Element.Catergoy.MISC, bind=0, value=false, dName="SmoothMC")
public class Smoother
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState() && EntityPlayerSP.isMoving()) {
            this.mc.gameSettings.limitFramerate = 0;
            Minecraft.player.distanceWalkedModified = 4.0f;
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.mc.gameSettings.enableVsync = true;
        active = false;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.mc.gameSettings.enableVsync = true;
        active = true;
    }

    @Override
    public String getValue() {
        return null;
    }
}

