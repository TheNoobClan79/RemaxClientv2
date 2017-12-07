/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

@Element.ElementInfo(name="InteractSlowdown", description="Stops you from slowing down when eating/ec.", category=Element.Catergoy.COMBAT, bind=0, value=false, dName="InteractSlowdown \u00a77[NCP]")
public class InteractSlowdown
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

