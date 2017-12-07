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
import net.minecraft.entity.Entity;

@Element.ElementInfo(name="HorseJump", description="Makes your horse jump super high", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="HorseJump \u00a77[Extra]")
public class HorseJump
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState() && Minecraft.player.ridingEntity != null && !Minecraft.player.ridingEntity.isDead && this.mc.gameSettings.keyBindJump.pressed && Minecraft.player.ridingEntity.onGround) {
            Minecraft.player.getRidingEntity().motionY = 1.8;
        }
    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getValue() {
        return null;
    }
}

