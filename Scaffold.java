/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;
import com.zhn.Remax.utils.BlockUtils;
import com.zhn.Remax.utils.EntityUtils;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;

@Element.ElementInfo(name="Scaffold", description="Places blocks below your feet.", category=Element.Catergoy.PLAYER, bind=0, value=false, dName="Scaffold")
public class Scaffold
extends Element {
    public static boolean active;
    boolean placing;
    private boolean count = true;
    private int slot;
    public static int blockcount;
    private int original;
    double groundy = 0.0;
    int counter;

    @EventTarget
    public void onUpdate(EventUpdate event) {
        if (this.getState()) {
            Minecraft.player.setSprinting(false);
            BlockPos belowPlayer = new BlockPos(Minecraft.player).down();
            if (!EntityUtils.getMaterial(belowPlayer).isReplaceable()) {
                return;
            }
            int newSlot = -1;
            int i = 0;
            while (i < 9) {
                ItemStack stack = Minecraft.player.inventory.getStackInSlot(i);
                if (!EntityUtils.isNull(stack) && stack.getItem() instanceof ItemBlock && Block.getBlockFromItem(stack.getItem()).getDefaultState().isFullBlock()) {
                    newSlot = i;
                    break;
                }
                ++i;
            }
            if (newSlot == -1) {
                return;
            }
            int oldSlot = Minecraft.player.inventory.currentItem;
            Minecraft.player.inventory.currentItem = newSlot;
            BlockUtils.placeBlockScaffold(belowPlayer);
            Minecraft.player.motionX = 0.0;
            Minecraft.player.motionZ = 0.0;
            Minecraft.player.setSprinting(false);
            Minecraft.player.inventory.currentItem = oldSlot;
        }
        this.counter += 1;
        if (this.counter > 1.189546D && (this.mc.gameSettings.keyBindJump.pressed) && !mc.gameSettings.keyBindForward.pressed && !mc.gameSettings.keyBindLeft.pressed && !mc.gameSettings.keyBindRight.pressed && !mc.gameSettings.keyBindBack.pressed)
        {
                Minecraft.player.motionY=+0.42D-0.03D;;
                mc.player.rotationPitch = 90;
                mc.player.connection.sendPacket(new CPacketPlayer.Rotation(mc.player.rotationYaw, mc.player.rotationPitch = 90, mc.player.onGround));
                this.counter = 0;
        }else  if (this.counter > 1.189546D && (this.mc.gameSettings.keyBindJump.pressed) && !mc.gameSettings.keyBindForward.pressed && !mc.gameSettings.keyBindLeft.pressed && !mc.gameSettings.keyBindRight.pressed && !mc.gameSettings.keyBindBack.pressed)
        {
            Minecraft.player.motionY = 0.42D;
            this.counter = 0;
    }
    }

    private IBlockState state(BlockPos pos) {
        return Minecraft.world.getBlockState(pos);
    }

    private Block block(BlockPos pos) {
        return this.state(pos).getBlock();
    }

    private Material material(BlockPos pos) {
        return this.block(pos).getMaterial(this.state(pos));
    }

    private boolean empty(ItemStack item) {
        if (item == null) {
            return true;
        }
        return false;
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

