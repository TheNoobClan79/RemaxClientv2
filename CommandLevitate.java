/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.element.elements.Levitate;

public class CommandLevitate
extends Command {
    @Override
    public String getName() {
        return "levitate";
    }

    @Override
    public String getSyntax() {
        return "levitate <normal/weird/old>";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            if (args[0].equalsIgnoreCase("normal")) {
                Levitate.Mode1 = true;
                Levitate.Mode2 = false;
                ClientInterface.addChatMessage("Levitate mode changed to: " + args[0], true);
            }
            if (args[0].equalsIgnoreCase("weird")) {
                Levitate.Mode2 = true;
                Levitate.Mode1 = false;
                ClientInterface.addChatMessage("Levitate mode changed to: " + args[0], true);
            }
            if (args[0].equalsIgnoreCase("old")) {
                Levitate.Mode3 = true;
                Levitate.Mode2 = false;
                Levitate.Mode1 = false;
                ClientInterface.addChatMessage("Levitate mode changed to: " + args[0], true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            ClientInterface.addChatMessage("Usage: " + this.getSyntax(), true);
        }
    }
}

