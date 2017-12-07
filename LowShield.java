/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

@Element.ElementInfo(name="LowShield", description="Makes your Offhand slightly lower.", category=Element.Catergoy.RENDER, bind=0, value=false, dName="LowShield")
public class LowShield
extends Element {
    @EventTarget
    public void onUpdate(EventUpdate event) {
        this.getState();
    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getValue() {
        return null;
    }
}

