/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command;

import java.util.ArrayList;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.command.commands.CommandAuthors;
import com.zhn.Remax.command.commands.CommandBind;
import com.zhn.Remax.command.commands.CommandClearChat;
import com.zhn.Remax.command.commands.CommandFriend;
import com.zhn.Remax.command.commands.CommandHCLIP;
import com.zhn.Remax.command.commands.CommandLevitate;
import com.zhn.Remax.command.commands.CommandPacketFly;
import com.zhn.Remax.command.commands.CommandSay;
import com.zhn.Remax.command.commands.CommandSpeed;
import com.zhn.Remax.command.commands.CommandToggle;
import com.zhn.Remax.command.commands.CommandVCLIP;
import com.zhn.Remax.command.commands.help.CommandHelp;
import com.zhn.Remax.utils.ChatUtils;

public class CommandManager {
    public ArrayList<Command> commands = new ArrayList();
    public char prefix = 46;

    public void loadCommands() {
        this.add(new CommandHelp());
        this.add(new CommandAuthors());
        this.add(new CommandToggle());
        this.add(new CommandBind());
        this.add(new CommandClearChat());
        this.add(new CommandVCLIP());
        this.add(new CommandHCLIP());
        this.add(new CommandSay());
        this.add(new CommandSpeed());
        this.add(new CommandLevitate());
        this.add(new CommandFriend());
        this.add(new CommandPacketFly());
    }

    public void runCommands(String s) {
        if (!s.contains(Character.toString(this.prefix)) || !s.startsWith(Character.toString(this.prefix))) {
            return;
        }
        boolean resolved = false;
        String readString = s.trim().substring(Character.toString(this.prefix).length()).trim();
        boolean hasArgs = readString.trim().contains(" ");
        String cmdName = hasArgs ? readString.split(" ")[0] : readString.trim();
        String[] args = hasArgs ? readString.substring(cmdName.length()).trim().split(" ") : new String[]{};
        for (Command cmd : this.commands) {
            if (!cmd.getName().trim().equalsIgnoreCase(cmdName.trim())) continue;
            cmd.execute(readString, args);
            resolved = true;
            break;
        }
        if (!resolved) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Err.. Maybe try \u00a78.help\u00a77?");
        }
    }

    public void add(Command cmd) {
        this.commands.add(cmd);
    }

    public ArrayList<Command> getAllCommands() {
        return this.commands;
    }

    public Command findCommand(Class<? extends Command> commandClass) {
        for (Command cmd : this.commands) {
            if (cmd.getClass() != commandClass) continue;
            return cmd;
        }
        return null;
    }
}

