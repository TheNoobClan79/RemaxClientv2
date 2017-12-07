/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.utils.ChatUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;

public class CommandSay
extends Command {
    @Override
    public String getName() {
        return "say";
    }

    @Override
    public String getSyntax() {
        return "say <something>";
    }

    @Override
    public String getDescription() {
        return "Say's something in chat.";
    }

    @Override
    public void execute(String s, String[] args) {
        if (args.length != 1) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77You have to specify a message. I can't send the message ' '.");
        } else {
            Minecraft.player.sendChatMessage(s.substring(args[1].length()));
        }
    }
}

