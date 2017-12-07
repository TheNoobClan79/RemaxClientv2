/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.element.elements.Speed;

public class CommandSpeed
extends Command {
    @Override
    public String getName() {
        return "speed";
    }

    @Override
    public String getSyntax() {
        return "speed <groundhop/boost>";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            if (args[0].equalsIgnoreCase("groundhop")) {
                Speed.Mode1 = true;
                Speed.Mode2 = false;
                ClientInterface.addChatMessage("Speed mode changed to: " + args[0], true);
            }
            if (args[0].equalsIgnoreCase("boost")) {
                Speed.Mode2 = true;
                Speed.Mode1 = false;
                ClientInterface.addChatMessage("Speed mode changed to: " + args[0], true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            ClientInterface.addChatMessage("Usage: " + this.getSyntax(), true);
        }
    }
}

