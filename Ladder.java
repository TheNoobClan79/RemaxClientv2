/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

@Element.ElementInfo(name="Ladder", description="Boosts you/skips you up ladders.", category=Element.Catergoy.MISC, bind=0, value=false, dName="Ladder")
public class Ladder
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        boolean flag1;
        if (this.getState() && (flag1 = Minecraft.player.isOnLadder())) {
            Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX + Minecraft.player.motionX, Minecraft.player.posY + (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() ? 0.0612 : 0.0) - (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown() ? 0.0612 : 0.0), Minecraft.player.posZ + Minecraft.player.motionZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, false));
            Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX + Minecraft.player.motionX, Minecraft.player.posY - 999.0, Minecraft.player.posZ + Minecraft.player.motionZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, true));
            Minecraft.player.motionY = 0.0;
            this.mc.gameSettings.keyBindJump.pressed = true;
        }
    }

    @Override
    public void onDisable() {
        this.mc.gameSettings.keyBindJump.pressed = false;
    }

    @Override
    public String getValue() {
        return null;
    }
}

