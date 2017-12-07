/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.utils.ChatUtils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.GuiNewChat;

public class CommandClearChat
extends Command {
    @Override
    public String getName() {
        return "clearchat";
    }

    @Override
    public String getSyntax() {
        return "clearchat";
    }

    @Override
    public String getDescription() {
        return "Clear's the chat.";
    }

    @Override
    public void execute(String s, String[] args) {
        Minecraft.getMinecraft().ingameGUI.getChatGUI().clearChatMessages(true);
        ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Cleared Chat.");
    }
}

