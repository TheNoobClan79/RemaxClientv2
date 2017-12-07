/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

@Element.ElementInfo(name="yPort", description="Idiot", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="yPort")
public class yPort
extends Element {
    public static boolean active;
    private double damage = 0.5;
    private int acc;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            this.acc = 0;
            if (EntityPlayerSP.isMoving() && !Minecraft.player.isCollidedHorizontally) {
                if ((double)Minecraft.player.fallDistance > 3.994) {
                    return;
                }
                if (Minecraft.player.isInWater() || Minecraft.player.isOnLadder()) {
                    return;
                }
                EntityPlayerSP thePlayer = Minecraft.player;
                thePlayer.posY -= 0.3993000090122239;
                Minecraft.player.motionY = -1000.0;
                Minecraft.player.cameraPitch = 0.0f;
            }
            if (Minecraft.player.isInWater() || Minecraft.player.isOnLadder()) {
                return;
            }
            if (Minecraft.player.onGround && EntityPlayerSP.isMoving()) {
                Minecraft.player.posY += 0.3993000090122239;
                Minecraft.player.motionY = 0.3993000090122239;
                Minecraft.player.motionX *= 1.138910033378613;
                Minecraft.player.motionZ *= 1.138910033378613;
                Minecraft.player.cameraPitch = 0.0f;
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

