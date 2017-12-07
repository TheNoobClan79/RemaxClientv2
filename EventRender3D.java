/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.event.events;

import com.zhn.Remax.event.Event;

public class EventRender3D
extends Event {
    public static float particlTicks;

    public EventRender3D(float particlTicks) {
        EventRender3D.particlTicks = particlTicks;
    }

    public float getParticlTicks() {
        return particlTicks;
    }

    public void setParticlTicks(float particlTicks) {
        EventRender3D.particlTicks = particlTicks;
    }
}

