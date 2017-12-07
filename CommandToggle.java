/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.element.Element;
import com.zhn.Remax.element.ElementManager;
import com.zhn.Remax.utils.ChatUtils;

public class CommandToggle
extends Command {
    @Override
    public String getName() {
        return "toggle";
    }

    @Override
    public String getSyntax() {
        return ".toggle <module>";
    }

    @Override
    public String getDescription() {
        return "Automatically toggles a module for the user.";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            boolean valid = false;
            for (Element module : ElementManager.getAllModules()) {
                if (!module.getName().trim().toLowerCase().equalsIgnoreCase(s.substring(7))) continue;
                module.toggle();
                ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Toggled \u00a78" + module.getName() + " " + (module.getState() ? "\u00a77On." : "\u00a77Off."));
                valid = true;
                break;
            }
            if (!valid) {
                ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77I can't find the Element \u00a78" + args[0] + "\u00a77.");
            }
        }
        catch (Exception e) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a77Wrong! Usage: \u00a78" + this.getSyntax());
        }
    }
}

