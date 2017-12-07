/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.MovementInput;

@Element.ElementInfo(name="EntitySpeed", description="Makes you go faster with rideable entities.", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="EntitySpeed")
public class EntitySpeed
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState() && Minecraft.player.ridingEntity != null) {
            MovementInput movementInput = Minecraft.player.movementInput;
            double forward = MovementInput.field_192832_b;
            double strafe = MovementInput.moveStrafe;
            float yaw = Minecraft.player.rotationYaw;
            if (forward == 0.0 && strafe == 0.0) {
                Minecraft.player.ridingEntity.motionX = 0.0;
                Minecraft.player.ridingEntity.motionZ = 0.0;
            } else {
                if (forward != 0.0) {
                    if (strafe > 0.0) {
                        yaw += (float)(forward > 0.0 ? -45 : 45);
                    } else if (strafe < 0.0) {
                        yaw += (float)(forward > 0.0 ? 45 : -45);
                    }
                    strafe = 0.0;
                    if (forward > 0.0) {
                        forward = 1.0;
                    } else if (forward < 0.0) {
                        forward = -1.0;
                    }
                }
                Minecraft.player.ridingEntity.motionX = forward * 2.0 * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * 2.0 * Math.sin(Math.toRadians(yaw + 90.0f));
                Minecraft.player.ridingEntity.motionZ = forward * 2.0 * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * 2.0 * Math.cos(Math.toRadians(yaw + 90.0f));
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @Override
    public String getValue() {
        return null;
    }
}

