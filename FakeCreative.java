/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.GameType;

@Element.ElementInfo(name="FakeCreative", description="", category=Element.Catergoy.PLAYER, bind=0, value=false, dName="FakeCreative \u00a77[Client-Side]")
public class FakeCreative
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.getMinecraft();
            Minecraft.playerController.setGameType(GameType.CREATIVE);
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
        Minecraft.getMinecraft();
        Minecraft.playerController.setGameType(GameType.SURVIVAL);
        active = false;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Minecraft.player.addChatMessage(new TextComponentString("\u00a77\u00a7o[Server: Opped " + Minecraft.player.getName() + "]"));
        active = true;
    }

    @Override
    public String getValue() {
        return null;
    }
}

