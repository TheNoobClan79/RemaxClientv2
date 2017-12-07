package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.element.Element.Catergoy;
import com.zhn.Remax.element.Element.ElementInfo;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.ItemAir;
import net.minecraft.item.ItemStack;

@Element.ElementInfo(name="NoHand", description="Won't display your in game hand, only items.", category=Element.Catergoy.RENDER, bind=0, value=false, dName="NoHand")
public class NoHand
  extends Element
{
  @EventTarget
  public void onUpdate(EventUpdate event)
  {
    if ((getState()) && 
      ((Minecraft.player.getHeldItemMainhand().getItem() instanceof ItemAir))) {
      this.mc.getItemRenderer().equippedProgressMainHand = -0.7F;
    }
  }
  
  public void onDisable()
  {
    super.onDisable();
  }
  
  public void onEnable()
  {
    super.onEnable();
  }
  
  public String getValue()
  {
    return null;
  }
}
