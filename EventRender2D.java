/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.event.events;

import com.zhn.Remax.event.Event;

public class EventRender2D
extends Event {
    public int width;
    public int height;

    public EventRender2D(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

