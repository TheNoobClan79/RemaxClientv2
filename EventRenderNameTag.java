/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.event.events;

import com.zhn.Remax.event.Event;

import net.minecraft.entity.Entity;

public class EventRenderNameTag
extends Event {
    public static boolean cancel;
    private Entity entity;

    public EventRenderNameTag(Entity entity) {
        this.entity = entity;
    }

    public Entity getEntity() {
        return this.entity;
    }
}

