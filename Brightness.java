/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

@Element.ElementInfo(name="Brightness", description="", category=Element.Catergoy.RENDER, bind=0, value=false, dName="Brightness")
public class Brightness
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            PotionEffect nv = new PotionEffect(Potion.getPotionById(16), 9999999, 3);
            Minecraft.player.addPotionEffect(nv);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Minecraft.player.removeActivePotionEffect(Potion.getPotionById(16));
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

