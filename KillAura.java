/*
 * Decompiled with CFR 0_123.
 */
package com.zhn.Remax.element.elements;

import java.util.List;

import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.element.Element;
import com.zhn.Remax.element.ElementManager;
import com.zhn.Remax.element.elements.Criticals;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventPostMotionUpdates;
import com.zhn.Remax.friend.FriendManager;
import com.zhn.Remax.utils.EntityUtils;
import com.zhn.Remax.utils.TimerUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

@Element.ElementInfo(name="Aura", description="You should know what this does", category=Element.Catergoy.COMBAT, bind=19, value=true, dName="Aura")
public class KillAura
extends Element {
    TimerUtil timer = new TimerUtil();

    @EventTarget
    public void onUpdate(EventPostMotionUpdates event) {
        if (this.getState()) {
            Minecraft.getMinecraft();
            Minecraft.getMinecraft();
            for (Object theObject : Minecraft.world.loadedEntityList) {
                Entity e = (Entity)theObject;
                if (!(theObject instanceof EntityLivingBase)) continue;
                EntityLivingBase entity = (EntityLivingBase)theObject;
                Minecraft.getMinecraft();
                if (e != Minecraft.player && e instanceof EntityLivingBase) {
                    Minecraft.getMinecraft();
                    if ((double)Minecraft.player.getDistanceToEntity(e) <= 5.1 && !e.isDead && entity.isEntityAlive() && !e.isInvisible() && Minecraft.player.getCooledAttackStrength(0.0f) == 1.0f) {
                        boolean shouldAttack;
                        if (ClientInterface.INSTANCE.MODULE_MANAGER.getModuleByClass(Criticals.class).getState()) {
                            Criticals.doCriticalHit();
                            Minecraft.player.onCriticalHit(entity);
                        }
                        if (FriendManager.isFriend(entity.getName())) {
                            shouldAttack = false;
                        } else if (!FriendManager.isFriend(entity.getName())) {
                            shouldAttack = true;
                            Minecraft.playerController.attackEntity(Minecraft.player, entity);
                            Minecraft.player.swingArm(EnumHand.MAIN_HAND);
                            Minecraft.player.isSwingInProgress = true;
                            EntityUtils entityUtils = new EntityUtils();
                            entityUtils.faceEntityPacket(entity);
                        }
                        this.timer.reset();
                    }
                }
                Minecraft.getMinecraft();
            }
        }
    }

    @Override
    public String getValue() {
        return "Hand Spoof";
    }
}

