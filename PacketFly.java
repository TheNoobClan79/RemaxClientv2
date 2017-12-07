/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;
import com.zhn.Remax.option.Option;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.MathHelper;

@Element.ElementInfo(name="PacketFly", description="", category=Element.Catergoy.PLAYER, bind=0, value=true, dName="PacketFly §7[Normal]")
public class PacketFly
extends Element {
	
    public static boolean active;
    int clock = 0;
    @Option.Op(name="", dName="PacketFly §7[Normal]")
    public static boolean Mode1 = true;
    @Option.Op(name="", dName="PacketFly §7[2b2t]")
    public static boolean Mode2 = false;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
        	  if (Mode1)
              {
                mode1();
                Mode1 = true;
                if (Mode2) {
                  Mode2 = false;
                }
                setDName("Speed §7[GroundHop]");
              }
              else if (Mode2)
              {
                mode2();
                Mode2 = true;
                if (Mode1) {
                  Mode1 = false;
                }
                setDName("Speed §7[HorseHop]");
              }
            }
    }
    
    private void mode1() {
    	if(Mode1) {
    		this.setDName("PacketFly §7[Normal]");
    		 float forward = 0.0f;
             float strafe = 0.0f;
             double speed = 0.2;
             Minecraft.getMinecraft();
             EntityPlayerSP player = Minecraft.player;
             float var5 = MathHelper.sin(Minecraft.player.rotationYaw * 3.1415927f / 180.0f);
             float var6 = MathHelper.cos(Minecraft.player.rotationYaw * 3.1415927f / 180.0f);
             if (this.mc.gameSettings.keyBindForward.pressed) {
                 forward += 0.1f;
             }
             if (this.mc.gameSettings.keyBindBack.pressed) {
                 forward -= 0.1f;
             }
             if (this.mc.gameSettings.keyBindLeft.pressed) {
                 strafe += 0.01f;
             }
             if (this.mc.gameSettings.keyBindRight.pressed) {
                 strafe -= 0.01f;
             }
             if (!Minecraft.player.isDead) {
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 speed = 2.7999100260353087;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 double motionX = (double)(strafe * var6 - forward * var5) * speed;
                 double motionZ = (double)(forward * var6 + strafe * var5) * speed;
                 Minecraft.player.motionX = motionX;
                 Minecraft.player.motionZ = motionZ;
                 if (!this.mc.gameSettings.keyBindJump.pressed) {
                     Minecraft.player.setPosition(Minecraft.player.posX, Minecraft.player.posY - 0.03948584, Minecraft.player.posZ);
                 }
                 Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX + Minecraft.player.motionX, Minecraft.player.posY + (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() ? 0.0621 : 0.0) - (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown() ? 0.0621 : 0.0), Minecraft.player.posZ + Minecraft.player.motionZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, false));
                 Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX + Minecraft.player.motionX, Minecraft.player.posY - 999.0, Minecraft.player.posZ + Minecraft.player.motionZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, true));
             }
             Minecraft.player.motionY = 0.0;
             ++this.clock;
             if (this.clock >= 12) {
                 this.clock = 0;
             }
    	}
    }
    
    private void mode2() {
    	if(Mode2) {
    		this.setDName("PacketFly §7[2b2t]");
    		 float forward = 0.0f;
             float strafe = 0.0f;
             double speed = 0.2;
             Minecraft.getMinecraft();
             EntityPlayerSP player = Minecraft.player;
             float var5 = MathHelper.sin(Minecraft.player.rotationYaw * 3.1415927f / 180.0f);
             float var6 = MathHelper.cos(Minecraft.player.rotationYaw * 3.1415927f / 180.0f);
             if (this.mc.gameSettings.keyBindForward.pressed) {
                 forward += 0.1f;
             }
             if (this.mc.gameSettings.keyBindBack.pressed) {
                 forward -= 0.1f;
             }
             if (this.mc.gameSettings.keyBindLeft.pressed) {
                 strafe += 0.01f;
             }
             if (this.mc.gameSettings.keyBindRight.pressed) {
                 strafe -= 0.01f;
             }
             if (!Minecraft.player.isDead) {
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 speed = 2.7999100260353087;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionZ = player.posZ * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 Minecraft.player.motionX = player.posX * 5.01E-8;
                 double motionX = (double)(strafe * var6 - forward * var5) * speed;
                 double motionZ = (double)(forward * var6 + strafe * var5) * speed;
                 Minecraft.player.motionX = motionX;
                 Minecraft.player.motionZ = motionZ;
                 if (!this.mc.gameSettings.keyBindJump.pressed) {
                     Minecraft.player.setPosition(Minecraft.player.posX, Minecraft.player.posY - 0.03948584, Minecraft.player.posZ);
                 }
             }
             Minecraft.player.motionY = 0.0;
             ++this.clock;
             if (this.clock >= 2) {
            	 Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX + Minecraft.player.motionX, Minecraft.player.posY + (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown() ? 0.0621 : 0.0) - (Minecraft.getMinecraft().gameSettings.keyBindSneak.isKeyDown() ? 0.0621 : 0.0), Minecraft.player.posZ + Minecraft.player.motionZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, false));
                 Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX + Minecraft.player.motionX, Minecraft.player.posY - 999.0, Minecraft.player.posZ + Minecraft.player.motionZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, true));
                 this.clock = 0;
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
        return "Fast";
    }
}

