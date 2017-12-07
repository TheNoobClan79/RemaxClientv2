/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;

@Element.ElementInfo(name="Criticals", description="Auto does a critical hit.", category=Element.Catergoy.COMBAT, bind=-0, value=false, dName="Criticals")
public class Criticals
extends Element {
    public static void doCriticalHit() {
        double[] arrd = new double[]{0.01, 0.0, 0.003, 0.0};
        int n = arrd.length;
        int n2 = 0;
        while (n2 < n) {
            double critical = arrd[n2];
            Minecraft mc = Minecraft.getMinecraft();
            if (Criticals.canDoCriticalHit()) {
                Minecraft.player.connection.sendPacket(new CPacketPlayer.Position(Minecraft.player.posX, Minecraft.player.posY + 0.04D, Minecraft.player.posZ, false));
            }
            ++n2;
        }
    }

    private static boolean canDoCriticalHit() {
        Minecraft mc = Minecraft.getMinecraft();
        if (!Minecraft.player.onGround) {
            return false;
        }
        if (Minecraft.player.isInLiquid()) {
            return false;
        }
        if (mc.gameSettings.keyBindJump.pressed) {
            return false;
        }
        return true;
    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getValue() {
        return null;
    }
}

