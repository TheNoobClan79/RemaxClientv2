/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.element.Element;
import com.zhn.Remax.utils.ChatUtils;

@Element.ElementInfo(name="ChestESP", description="Highlight's chests.", bind=0, category=Element.Catergoy.RENDER, value=false, dName="ChestESP")
public class ChestESP
extends Element {
    @Override
    public void onEnable() {
        ClientInterface.INSTANCE.CHAT_UTILS.tellPlayer("NEED'S DOING!!");
    }

    @Override
    public String getValue() {
        return null;
    }
}

