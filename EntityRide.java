/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

@Element.ElementInfo(name="EntityRide", description="Allows you to ride pigs without a saddle, and will auto put a client sided saddle on horses.", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="EntityRide \u00a77[Horse, Pig]")
public class EntityRide
extends Element {
    public static boolean active;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        this.getState();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        active = false;
    }

    @Override
    public void onEnable() {
        super.onEnable();
        active = true;
    }

    @Override
    public String getValue() {
        return null;
    }
}

