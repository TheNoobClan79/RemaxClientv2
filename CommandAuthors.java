/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import java.util.Arrays;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.utils.ChatUtils;

public class CommandAuthors
extends Command {
    @Override
    public String getName() {
        return "authors";
    }

    @Override
    public String getSyntax() {
        return "authors";
    }

    @Override
    public String getDescription() {
        return "Show's the authors of this client";
    }

    @Override
    public void execute(String s, String[] args) {
        ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Client Coded by: \u00a78" + Arrays.asList(ClientInterface.INSTANCE.authors));
    }
}

