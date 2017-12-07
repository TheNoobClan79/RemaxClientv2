/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.utils.ChatUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class CommandHCLIP
extends Command {
    @Override
    public String getName() {
        return "hclip";
    }

    @Override
    public String getSyntax() {
        return "hclip <distance>";
    }

    @Override
    public String getDescription() {
        return "Teleports you forward some blocks, patched on almost any AntiCheat if the value is over '2'";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            double playerYaw = Minecraft.player.rotationYaw;
            int increment = Integer.parseInt(args[0].trim());
            Minecraft.player.setPosition(Minecraft.player.posX + Math.sin(Math.toRadians(- playerYaw)) * (double)increment, Minecraft.player.posY, Minecraft.player.posZ + Math.cos(Math.toRadians(- playerYaw)) * (double)increment);
        }
        catch (Exception e) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Wrong! Usage: \u00a78" + this.getSyntax());
        }
    }
}

