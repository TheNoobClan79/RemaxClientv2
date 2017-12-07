package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;
import com.zhn.Remax.option.Option;
import com.zhn.Remax.utils.TimeHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockAir;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

@Element.ElementInfo(name="Speed", description="Makes you go faster than the original Vanilla Minecraft speed.", category=Element.Catergoy.MOVEMENT, bind=0, value=false, dName="Speed §7[GroundHop]")
public class Speed
  extends Element
{
  public static boolean active;
  private double moveSpeed;
  int counter;
  TimeHelper time;
  private double lastDist;
  public static int stage;
  public boolean sink = false;
  @Option.Op(name="Ground Hop", dName="Speed §7[GroundHop]")
  public static boolean Mode1 = true;
  @Option.Op(name="Boost", dName="Speed §7[Boost]")
  public static boolean Mode2 = false;
  
  @EventTarget
  public void onUpdate(EventUpdate event)
  {
    if (getState()) {
      if (Mode1)
      {
        mode1();
        Mode1 = true;
        if (Mode2) {
          Mode2 = false;
        }
        setDName("Speed §7[GroundHop]");
      }
      else if (Mode2)
      {
        mode2();
        Mode2 = true;
        if (Mode1) {
          Mode1 = false;
        }
        setDName("Speed §7[HorseHop]");
      }
    }
  }
  
  private void mode1()
  {
    if (Mode1)
    {
      setDName("Speed §7[GroundHop]");
      if ((Minecraft.player.onGround) && (EntityPlayerSP.isMoving()))
      {
        this.sink = (!this.sink);
        this.counter += 1;
        if (this.counter > 3.189546D)
        {
          Minecraft.player.motionX *= 0.009999999776482582D;
          Minecraft.player.motionZ *= 0.009999999776482582D;
          Minecraft.player.getHeldItemMainhand().damageItem(0, Minecraft.player);
          Minecraft.player.hurtTime = 62284;
          
          this.counter = 0;
        }
        Minecraft.player.motionX *= 1.8300000429153442D;
        Minecraft.player.motionZ *= 1.8300000429153442D;
        Minecraft.player.hurtResistantTime = 1;
        Minecraft.player.motionY = 
          (Minecraft.player.isSneaking() ? -0.02D : this.mc.gameSettings.keyBindJump.pressed ? 0.43D : this.sink ? 0.37D : 0.25D);
        Minecraft.player.ridingEntity.motionY = 
          (Minecraft.player.isSneaking() ? -0.12D : this.mc.gameSettings.keyBindJump.pressed ? 0.43D : this.sink ? 0.45D : 0.12D);
        if (!EntityPlayerSP.isMoving())
        {
          Minecraft.player.motionX = 0.0D;
          Minecraft.player.motionZ = 0.0D;
        }
      }
    }
  }
  
  private void mode2()
  {
    if (Mode2)
    {
      setDName("Speed §7[HorseHop WIP]");
      if ((Minecraft.player.onGround) && (EntityPlayerSP.isMoving()))
      {
        this.sink = (!this.sink);
        this.counter += 1;
        if (this.counter > 3.2D)
        {
          Minecraft.player.motionX *= 0.009999999776482582D;
          Minecraft.player.motionZ *= 0.009999999776482582D;
          
          this.counter = 0;
        }
        Minecraft.player.jump();Minecraft.player.motionX *= 0.7400000095367432D;
        Minecraft.player.motionZ *= 0.7400000095367432D;
        Minecraft.player.motionY = 
          (Minecraft.player.isSneaking() ? -0.02D : this.mc.gameSettings.keyBindJump.pressed ? 0.13D : this.sink ? 0.09D : 0.02D);
        Minecraft.player.ridingEntity.motionY = 
          (Minecraft.player.isSneaking() ? -0.12D : this.mc.gameSettings.keyBindJump.pressed ? 0.43D : this.sink ? 0.45D : 0.12D);
        if (!EntityPlayerSP.isMoving())
        {
          Minecraft.player.motionX = 0.0D;
          Minecraft.player.motionZ = 0.0D;
        }
      }
    }
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
  
  public void onDisable()
  {
    super.onDisable();
    net.minecraft.util.Timer.elapsedTicks = 1.0D;
    active = false;
  }
  
  public void onEnable()
  {
    super.onEnable();
    
    this.lastDist = 0.0D;
    stage = 2;
    net.minecraft.util.Timer.elapsedTicks = 1.0D;
    active = true;
  }
  
  public String getValue()
  {
    return null;
  }
}
