package com.zhn.Remax.element.elements;

import org.lwjgl.input.Keyboard;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.InventoryEffectRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.ClickType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

/**
 * .
 */
@Element.ElementInfo(name = "AutoArmor", description = "Auto puts on armor", category = Element.Catergoy.PLAYER, bind = Keyboard.KEY_NONE, value = false, dName = "AutoArmor")
public class AutoArmor extends Element {

	public static int timer;
	public static boolean active;
	private final Item NULL_ITEM = Item.getItemFromBlock(Blocks.AIR);

	@EventTarget
	public void onUpdate(EventUpdate event) {
		if (getState() && mc.player != null) {
			equipBestArmor();
		}
	}
	
	public void equipBestArmor() {
		if (this.timer > 0)
	    {
	      this.timer -= 1;
	      return;
	    }
	    if (((mc.currentScreen instanceof GuiContainer)) && (!(mc.currentScreen instanceof InventoryEffectRenderer))) {
	      return;
	    }
	    int[] bestArmorSlots = new int[4];
	    int[] bestArmorValues = new int[4];
	    for (int armorType = 0; armorType < 4; armorType++)
	    {
	      ItemStack oldArmor = Minecraft.player.inventory.armorItemInSlot(armorType);
	      if ((oldArmor != null) && ((oldArmor.getItem() instanceof ItemArmor))) {
	        bestArmorValues[armorType] = ((ItemArmor)oldArmor.getItem()).damageReduceAmount;
	      }
	      bestArmorSlots[armorType] = -1;
	    }
	    for (int slot = 0; slot < 36; slot++)
	    {
	      ItemStack stack = Minecraft.player.inventory.getStackInSlot(slot);
	      if ((stack != null) && ((stack.getItem() instanceof ItemArmor)))
	      {
	        ItemArmor armor = (ItemArmor)stack.getItem();
	        int armorType = getArmorType(armor);
	        int armorValue = armor.damageReduceAmount;
	        if (armorValue > bestArmorValues[armorType])
	        {
	          bestArmorSlots[armorType] = slot;
	          bestArmorValues[armorType] = armorValue;
	        }
	      }
	    }
	    for (int armorType = 0; armorType < 4; armorType++)
	    {
	      int slot = bestArmorSlots[armorType];
	      if (slot != -1)
	      {
	        ItemStack oldArmor = Minecraft.player.inventory.armorItemInSlot(armorType);
	        if ((oldArmor == null) || (!isEmptySlot(oldArmor)) || (Minecraft.player.inventory.getFirstEmptyStack() != -1))
	        {
	          if (slot < 9) {
	            slot += 36;
	          }
	          Minecraft.playerController.windowClick(0, 8 - armorType, 0, ClickType.QUICK_MOVE, Minecraft.player);
	          Minecraft.playerController.windowClick(0, slot, 0, ClickType.QUICK_MOVE, Minecraft.player);
	          
	          break;
	        }
	      }
	    }
	    this.timer = 4;
	  }
	
	 public int getArmorType(ItemArmor armor)
	  {
	    return armor.armorType.ordinal() - 2;
	  }
	  
	  public boolean isEmptySlot(ItemStack slot)
	  {
	    return slot.getItem() == this.NULL_ITEM;
	  }

	public void onDisable() {
		super.onDisable();
		active = false;
	}

	public void onEnable() {
		super.onEnable();
		this.timer = 0;
		active = true;
	}

	// Aint gonna bother making a new autoarmor, just gonna take xulus old one

	@Override
	public String getValue() {
		// TODO Auto-generated method stub
		return null;
	}
}