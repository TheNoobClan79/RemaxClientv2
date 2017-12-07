/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command.commands;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.command.Command;
import com.zhn.Remax.friend.FriendManager;
import com.zhn.Remax.utils.ChatUtils;

public class CommandFriend
extends Command {
    @Override
    public String getName() {
        return "friend";
    }

    @Override
    public String getSyntax() {
        return "friend add <name> | friend del <name>";
    }

    @Override
    public String getDescription() {
        return "Adds a player as a friend.";
    }

    @Override
    public void execute(String s, String[] args) {
        try {
            if (args[0].equalsIgnoreCase("add")) {
                if (FriendManager.isFriend(args[1])) {
                    ClientInterface.addChatMessage(String.valueOf(args[1]) + " is already in your friends list..", true);
                    return;
                }
                String alias = args[1];
                FriendManager.addFriend(args[1], alias);
                ClientInterface.addChatMessage("Added " + args[1] + " to your friends list.", true);
            } else if (args[0].equalsIgnoreCase("del")) {
                if (FriendManager.isFriend(args[1])) {
                    FriendManager.removeFriend(args[1]);
                    ClientInterface.addChatMessage("Removed " + args[1] + " from your friends list.", true);
                } else {
                    ClientInterface.addChatMessage(String.valueOf(args[1]) + " is not in your friends list..", true);
                }
            }
        }
        catch (Exception e) {
            ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("\u00a74Wrong! Usage: \u00a78" + this.getSyntax());
        }
    }
}

