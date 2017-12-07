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
import com.zhn.Remax.utils.EntityUtils;
import com.zhn.Remax.utils.TimerUtil;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityEnderCrystal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;

@Element.ElementInfo(name="CrystalAura", description="Auto attacks crystals around you.", category=Element.Catergoy.COMBAT, bind=45, value=false, dName="CrystalAura")
public class CrystalAura
extends Element {
    TimerUtil timer = new TimerUtil();

    @EventTarget
    public void onUpdate(EventPostMotionUpdates event) {
        if (this.getState()) {
            Minecraft.getMinecraft();
            Minecraft.getMinecraft();
            for (Object theObject : Minecraft.world.loadedEntityList) {
                Entity e = (Entity)theObject;
                if (!(theObject instanceof EntityEnderCrystal)) continue;
                EntityEnderCrystal entity = (EntityEnderCrystal)theObject;
                Minecraft.getMinecraft();
                if (e != Minecraft.player && e instanceof EntityEnderCrystal) {
                    float attacktime = Minecraft.player.getCooledAttackStrength(1.0f);
                    if ((double)Minecraft.player.getDistanceToEntity(e) <= 5.1 && !e.isDead && entity.isEntityAlive() && !e.isInvisible() && attacktime >= 1.0f) {
                        if (ClientInterface.INSTANCE.MODULE_MANAGER.getModuleByClass(Criticals.class).getState()) {
                            Criticals.doCriticalHit();
                            Minecraft.player.onCriticalHit(entity);
                        }
                        Minecraft.playerController.attackEntity(Minecraft.player, entity);
                        Minecraft.playerController.attackEntity(Minecraft.player, e);
                        Minecraft.player.swingArm(EnumHand.MAIN_HAND);
                        Minecraft.player.swingArm(EnumHand.MAIN_HAND);
                        Minecraft.player.swingArm(EnumHand.MAIN_HAND);
                        Minecraft.player.swingArm(EnumHand.MAIN_HAND);
                        Minecraft.player.isSwingInProgress = true;
                        Minecraft.player.swingArm(EnumHand.MAIN_HAND);
                        Minecraft.player.isSwingInProgress = true;
                        EntityUtils entityUtils = new EntityUtils();
                        this.timer.reset();
                    }
                }
                Minecraft.getMinecraft();
            }
        }
    }

    @Override
    public void onDisable() {
    }

    @Override
    public String getValue() {
        return null;
    }
}

