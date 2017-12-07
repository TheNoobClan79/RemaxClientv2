/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands.help;

import java.util.ArrayList;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.command.CommandManager;
import com.zhn.Remax.utils.ChatUtils;

public class CommandHelp
extends Command {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getSyntax() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Show's a list of commands.";
    }

    @Override
    public void execute(String s, String[] args) {
        for (Command cmd : ClientInterface.INSTANCE.COMMAND_MANAGER.getAllCommands()) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer(cmd.getName());
        }
    }
}

