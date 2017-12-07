/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.command;

public abstract class Command {
    public abstract String getName();

    public abstract String getSyntax();

    public abstract String getDescription();

    public abstract void execute(String var1, String[] var2);

    public String getCommand() {
        return this.getName();
    }
}

