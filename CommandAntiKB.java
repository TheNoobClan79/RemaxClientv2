/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.element.elements.AntiKnockback;

public class CommandAntiKB
extends Command {
    @Override
    public String getName() {
        return "antiknockback";
    }

    @Override
    public String getSyntax() {
        return "antiknockback <normal/motion>";
    }

    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            if (args[0].equalsIgnoreCase("normal")) {
                AntiKnockback.Mode1 = true;
                AntiKnockback.Mode2 = false;
                ClientInterface.addChatMessage("AntiKnockback mode changed to: Normal", true);
            }
            if (args[0].equalsIgnoreCase("motion")) {
                AntiKnockback.Mode2 = true;
                AntiKnockback.Mode1 = false;
                ClientInterface.addChatMessage("AntiKnockback mode changed to: Motion", true);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            ClientInterface.addChatMessage("Usage: " + this.getSyntax(), true);
        }
    }
}

