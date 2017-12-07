/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventManager;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;
import com.zhn.Remax.option.Option;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;

@Element.ElementInfo(name="Levitate", description="Fly/Glide mode", category=Element.Catergoy.MOVEMENT, bind=34, value=false, dName="Levitate \u00a77[Normal]")
public class Levitate
extends Element {
    public static boolean active;
    private double startY;
    @Option.Op(name="Normal", dName="Levitate \u00a77[Normal]")
    public static boolean Mode1;
    @Option.Op(name="Weird", dName="Levitate \u00a77[Weird]")
    public static boolean Mode2;
    @Option.Op(name="Old", dName="Levitate \u00a77[Old]")
    public static boolean Mode3;
    int counter;

    static {
        Mode1 = true;
        Mode2 = false;
        Mode3 = false;
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            if (Mode1) {
                this.mode1();
                Minecraft.player.motionY = 0.0;
                this.mode1();
                Mode1 = true;
                if (Mode2) {
                    Mode2 = false;
                    Mode3 = false;
                }
                this.setDName("Levitate \u00a77[Normal]");
            } else if (Mode2) {
                this.mode2();
                Minecraft.player.motionY = 0.0;
                this.mode2();
                Mode2 = true;
                if (Mode1) {
                    Mode1 = false;
                    Mode3 = false;
                }
                this.setDName("Levitate \u00a77[Weird]");
            } else if (Mode3) {
                this.mode3();
                this.mode3();
                Mode3 = true;
                if (Mode1 || Mode2) {
                    Mode1 = false;
                    Mode2 = false;
                }
                this.setDName("Levitate \u00a77[Old]");
            }
        }
    }

    private void mode1() {
        if (Mode1) {
            this.setDName("Levitate \u00a77[Normal]");
            if (this.mc.gameSettings.keyBindSneak.pressed) {
                Minecraft.player.motionY = -0.1;
            }
            if (this.mc.gameSettings.keyBindJump.pressed) {
                Minecraft.player.motionY = 0.1;
            }
        }
    }

    private void mode3() {
        if (Mode3) {
            this.setDName("Levitate \u00a77[Old]");
            Minecraft.getMinecraft();
            if (!Minecraft.player.onGround) {
                Minecraft.getMinecraft();
                if (Minecraft.getMinecraft().gameSettings.keyBindJump.pressed) {
                    Minecraft.player.motionY = Minecraft.player.posY < this.startY - 1.0 ? 0.2 : -0.05;
                    Minecraft.getMinecraft();
                }
            }
        }
    }

    private void mode2() {
        if (Mode2) {
            this.setDName("Levitate \u00a77[Weird]");
            ++this.counter;
            if ((double)this.counter > 3.2) {
                this.mc.gameSettings.keyBindSneak.pressed = true;
                Minecraft.player.motionX *= 1.2;
                Minecraft.player.attackedAtYaw = 1.0f;
                Minecraft.player.motionZ *= 1.2;
                this.counter = 0;
            } else {
                ++this.counter;
            }
            if ((double)this.counter > 3.7) {
                this.mc.gameSettings.keyBindSneak.pressed = false;
                this.counter = 0;
            }
            Minecraft.player.onGround = true;
            Minecraft.player.motionY = 0.0;
            Minecraft.player.motionX *= 0.2;
            Minecraft.player.attackedAtYaw = 1.0f;
            Minecraft.player.motionZ *= 0.2;
            Minecraft.player.resetPositionToBB();
            Minecraft.player.setPosition(Minecraft.player.posX, Minecraft.player.posY + 1.0E-9, Minecraft.player.posZ);
            if (Minecraft.player.ticksExisted % 3 == 0 && Minecraft.world.getBlockState(new BlockPos(Minecraft.player.posX, Minecraft.player.posY - 0.2, Minecraft.player.posZ)).getBlock() instanceof BlockAir) {
                Minecraft.player.connection.sendPacket(new CPacketPlayer.PositionRotation(Minecraft.player.posX, Minecraft.player.posY + -0.0, Minecraft.player.posZ, Minecraft.player.rotationYaw, Minecraft.player.rotationPitch, true));
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        EventManager.unregister(this);
        active = false;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        EventManager.register(this);
        if (Mode3) {
            Minecraft.getMinecraft();
            double startX = Minecraft.player.posX;
            Minecraft.getMinecraft();
            this.startY = Minecraft.player.posY;
            Minecraft.getMinecraft();
            double startZ = Minecraft.player.posZ;
            Minecraft.getMinecraft();
            Minecraft.player.motionY = 0.42;
            int i2 = 1;
            while (i2 < 4) {
                Minecraft.player.maxHurtTime = 9;
                Minecraft.player.performHurtAnimation();
                Minecraft.player.fallDistance = 0.0f;
                ++i2;
            }
        }
        active = true;
    }

    @Override
    public String getValue() {
        return null;
    }
}

