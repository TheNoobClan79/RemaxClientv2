/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;
import com.zhn.Remax.option.Option;

@Element.ElementInfo(name="AntiKnockback", description="", category=Element.Catergoy.COMBAT, bind=0, value=false, dName="AntiKnockback")
public class AntiKnockback
extends Element {
    public static boolean active;
    @Option.Op(dName="AntiKnockback")
    public static boolean Mode1;
    @Option.Op(dName="AntiKnockback \u00a77[Motion]")
    public static boolean Mode2;

    static {
        Mode1 = true;
        Mode2 = false;
    }

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            if (Mode1) {
                this.mode1();
                if (Mode2) {
                    Mode2 = false;
                }
                this.setDName("AntiKnockback");
            } else if (Mode2) {
                this.mode2();
                if (Mode1) {
                    Mode1 = false;
                }
                this.setDName("AntiKnockback \u00a77[Motion]");
            }
        }
    }

    private void mode1() {
        if (Mode1) {
            this.setDName("AntiKnockback");
        }
    }

    private void mode2() {
        if (Mode2) {
            this.setDName("AntiKnockback \u00a77[Motion]");
        }
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

