/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.lwjgl.input.Keyboard
 */
package com.zhn.Remax.command.commands;

import org.lwjgl.input.Keyboard;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.element.Element;
import com.zhn.Remax.element.ElementManager;
import com.zhn.Remax.utils.ChatUtils;

public class CommandBind
extends Command {
    @Override
    public String getName() {
        return "bind";
    }

    @Override
    public String getSyntax() {
        return "bind add <mod> <key> | bind del <mod>";
    }

    @Override
    public String getDescription() {
        return "Binds a command.";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            if (args[0].equalsIgnoreCase("add")) {
                if (args.length != 3) {
                    ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Wrong, Usage: \u00a78" + this.getSyntax());
                    return;
                }
                args[2] = args[2].toUpperCase();
                int key = Keyboard.getKeyIndex((String)args[2]);
                for (Element module : ElementManager.getAllModules()) {
                    if (!args[1].equalsIgnoreCase(module.getName())) continue;
                    module.setBind(Keyboard.getKeyIndex((String)Keyboard.getKeyName((int)key)));
                    ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Bound \u00a78" + module.getName() + " \u00a77to \u00a78" + module.getBind() + " \u00a77(" + Keyboard.getKeyName((int)key) + ")");
                }
            } else if (args[0].equals("del")) {
                for (Element module : ElementManager.getAllModules()) {
                    if (!module.getName().equalsIgnoreCase(args[1])) continue;
                    module.setBind(0);
                    ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a74Unbound \u00a78" + module.getName());
                }
            }
        }
        catch (Exception e) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a74Wrong! Usage: \u00a78" + this.getSyntax());
        }
    }
}

