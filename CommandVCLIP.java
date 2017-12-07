/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.utils.ChatUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.AxisAlignedBB;

public class CommandVCLIP
extends Command {
    @Override
    public String getName() {
        return "vclip";
    }

    @Override
    public String getSyntax() {
        return "vclip <distance>";
    }

    @Override
    public String getDescription() {
        return "Clip's up/down blocks.";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            String blockArgs = args[0];
            int blocks = Integer.parseInt(blockArgs);
            Minecraft.player.setEntityBoundingBox(Minecraft.player.getEntityBoundingBox().offset(0.0, blocks, 0.0));
        }
        catch (Exception e) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Wrong! Usage: \u00a78" + this.getSyntax());
        }
    }
}

