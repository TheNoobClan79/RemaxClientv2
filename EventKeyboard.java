/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.event.events;

import com.zhn.Remax.event.Event;

public class EventKeyboard
extends Event {
    public int key;

    public EventKeyboard(int key) {
        this.key = key;
    }

    public int getKey() {
        return this.key;
    }
}

