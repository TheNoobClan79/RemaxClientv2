package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.element.Element.Catergoy;
import com.zhn.Remax.element.Element.ElementInfo;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

@Element.ElementInfo(name="Jesus", description="Allows you to walk on Lava and Water", category=Element.Catergoy.PLAYER, bind=0, value=false, dName="Jesus")
public class Jesus
  extends Element
{
  public static boolean active;
  public boolean sink = false;
  
  @EventTarget
  public void onUpdate(EventUpdate event)
  {
    if (getState())
    {
      if ((Minecraft.player.ridingEntity != null) && (Minecraft.player.ridingEntity.isInWater()))
      {
        Minecraft.player.getRidingEntity().motionY = 0.5D;
        Minecraft.player.getRidingEntity().motionX *= 1.2D;
        Minecraft.player.getRidingEntity().motionZ *= 1.2D;
      }
      if ((isInLiquid()) && (!Minecraft.player.isSneaking()))
      {
        this.sink = (!this.sink);
        Minecraft.player.extinguish();
        Minecraft.player.motionY = 
        
          (Minecraft.player.isSneaking() ? -0.15D : this.mc.gameSettings.keyBindJump.pressed ? 0.47D : this.sink ? 0.05D : 0.07D);
        Minecraft.player.ridingEntity.motionY = 
        
          (Minecraft.player.isSneaking() ? -0.12D : this.mc.gameSettings.keyBindJump.pressed ? 0.13D : this.sink ? 0.05D : 0.07D);
        if (!EntityPlayerSP.isMoving())
        {
          Minecraft.player.motionX = 0.0D;
          Minecraft.player.motionZ = 0.0D;
        }
        Minecraft.player.getRidingEntity().motionY = 0.0D;
      }
    }
  }
  
  public void onDisable()
  {
    super.onDisable();
    active = false;
  }
  
  public static boolean isOnLiquid()
  {
    Minecraft.getMinecraft();
    if (Minecraft.player != null)
    {
      Minecraft.getMinecraft();
      if (Minecraft.player.getRidingEntity() != null) {}
    }
    else
    {
      return false;
    }
    boolean onLiquid = false;
    if ((Minecraft.player.isRiding()) && (Minecraft.player.isInWater())) {
      Minecraft.player.getRidingEntity().motionY = 0.0D;
    }
    Minecraft.getMinecraft();int y = (int)Minecraft.player.boundingBox.offset(0.0D, -0.01D, 0.0D).minY;
    Minecraft.getMinecraft();int x = MathHelper.floor(Minecraft.player.boundingBox.minX);
    do
    {
      Minecraft.getMinecraft();int z = MathHelper.floor(Minecraft.player.boundingBox.minZ);
      do
      {
        Minecraft.getMinecraft();Block block = Minecraft.world.getBlockState(new BlockPos(x, y, z)).getBlock();
        if ((block != null) && (!(block instanceof BlockAir)))
        {
          if (!(block instanceof BlockLiquid)) {
            return false;
          }
          onLiquid = true;
        }
        z++;Minecraft.getMinecraft();
      } while (z < 
        MathHelper.floor(Minecraft.player.boundingBox.maxZ) + 1);
      x++;Minecraft.getMinecraft();
    } while (x < 
      MathHelper.floor(Minecraft.player.boundingBox.maxX) + 1);
    return onLiquid;
  }
  
  public boolean isInLiquid()
  {
    if ((Minecraft.player.isRiding()) && (Minecraft.player.isInWater())) {
      Minecraft.player.getRidingEntity().motionY = 0.0D;
    }
    boolean inLiquid = false;
    Minecraft.getMinecraft();int y = (int)Minecraft.player.boundingBox.minY;
    Minecraft.getMinecraft();int x = MathHelper.floor(Minecraft.player.boundingBox.minX);
    do
    {
      Minecraft.getMinecraft();int z = MathHelper.floor(Minecraft.player.boundingBox.minZ);
      do
      {
        Minecraft.getMinecraft();Block block = Minecraft.world.getBlockState(new BlockPos(x, y, z)).getBlock();
        if ((block != null) && (!(block instanceof BlockAir)))
        {
          if (!(block instanceof BlockLiquid)) {
            return false;
          }
          inLiquid = true;
        }
        z++;Minecraft.getMinecraft();
      } while (z < 
        MathHelper.floor(Minecraft.player.boundingBox.maxZ) + 1);
      x++;Minecraft.getMinecraft();
    } while (x < 
      MathHelper.floor(Minecraft.player.boundingBox.maxX) + 1);
    return inLiquid;
  }
  
  public void onEnable()
  {
    super.onEnable();
    active = true;
  }
  
  public String getValue()
  {
    return null;
  }
}
