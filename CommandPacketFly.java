/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.element.elements.PacketFly;
import com.zhn.Remax.element.elements.Speed;

public class CommandPacketFly
extends Command {
    @Override
    public String getName() {
        return "packetfly";
    }

    @Override
    public String getSyntax() {
        return "packetfly <normal/2b2t>";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            if (args[0].equalsIgnoreCase("normal")) {
            	PacketFly.Mode1 = true;
                PacketFly.Mode2 = false;
                ClientInterface.addChatMessage("PacketFly mode changed to: " + args[0], true);
            }
            if (args[0].equalsIgnoreCase("2b2t")) {
            	PacketFly.Mode2 = true;
            	PacketFly.Mode1 = false;
                ClientInterface.addChatMessage("PacketFly mode changed to: " + args[0], true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            ClientInterface.addChatMessage("Usage: " + this.getSyntax(), true);
        }
    }
}

