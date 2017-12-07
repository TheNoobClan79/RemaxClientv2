/*
 * Decompiled with CFR 0_123.
 * 
 * Could not load the following classes:
 *  org.lwjgl.opengl.GL11
 */
package com.zhn.Remax.element.elements;

import java.awt.Color;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.Timer;
import org.lwjgl.opengl.GL11;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventRender3D;
import com.zhn.Remax.friend.FriendManager;
import com.zhn.Remax.utils.IRenderer;
import com.zhn.Remax.utils.R3DUtils;

@Element.ElementInfo(name="Tracers", description="Draws lines to closest players around you", category=Element.Catergoy.RENDER, bind=0, value=false, dName="Tracers")
public class Tracers
extends Element {
    public static boolean active;

    @EventTarget
    public void onRender3D(EventRender3D event) {
        if (this.getState() && event instanceof EventRender3D) {
            EventRender3D re = event;
            for (Object theObject : Minecraft.world.loadedEntityList) {
                EntityLivingBase entity;
                if (!(theObject instanceof EntityLivingBase) || (entity = (EntityLivingBase)theObject) instanceof EntityPlayerSP || !(entity != null & entity != Minecraft.player) || entity.isPlayerSleeping()) continue;
                Color tracercolor = Color.WHITE;
                int entitycolordistance = (int)Minecraft.player.getDistanceSqToEntity(entity) / 85;
                if (entitycolordistance >= 200) {
                    entitycolordistance = 199;
                }
                if (!entity.isInvisible() && entity instanceof EntityPlayer) {
                    int green = entitycolordistance * 11;
                    if (green >= 255) {
                        green = 255;
                    }
                    tracercolor = new Color(255 - green, 0 + green, 0, 255);
                    if (FriendManager.isFriend(entity.getName())) {
                        tracercolor = new Color(0, 0, 255, 255);
                    }
                }
                if (tracercolor == Color.WHITE) continue;
                R3DUtils.drawTracerLine(entity, tracercolor);
            }
        }
    }

    public void renderTracer(double x2, double y2, double z2) {
        GL11.glPushMatrix();
        GL11.glLoadIdentity();
        boolean bobbing = this.mc.gameSettings.viewBobbing;
        this.mc.gameSettings.viewBobbing = false;
        this.mc.entityRenderer.orientCamera(Timer.field_194147_b);
        GL11.glLineWidth((float)1.5f);
        GL11.glBegin((int)1);
        GL11.glVertex3d((double)0.0, (double)Minecraft.player.getEyeHeight(), (double)0.0);
        GL11.glVertex3d((double)x2, (double)y2, (double)z2);
        GL11.glEnd();
        GL11.glPopMatrix();
        this.mc.gameSettings.viewBobbing = bobbing;
    }

    public void player(EntityLivingBase entity, double partialTicks) {
        Color tracercolor = Color.WHITE;
        int entitycolordistance = (int)Minecraft.player.getDistanceSqToEntity(entity) / 85;
        if (entitycolordistance >= 200) {
            entitycolordistance = 199;
        }
        if (!entity.isInvisible() && entity instanceof EntityPlayer) {
            int green = entitycolordistance * 10;
            if (green >= 255) {
                green = 255;
            }
            tracercolor = new Color(255 - green, 0 + green, 0, 255);
        }
        this.mc.getRenderManager();
        double xPos = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * partialTicks - RenderManager.renderPosX;
        this.mc.getRenderManager();
        double yPos = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * partialTicks - RenderManager.renderPosY;
        this.mc.getRenderManager();
        double zPos = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * partialTicks - RenderManager.renderPosZ;
        if (tracercolor != Color.WHITE) {
            this.render(tracercolor, xPos, yPos, zPos);
        }
    }

    public void render(Color color, double x, double y, double z) {
        IRenderer.drawTracerLine(x, y, z, color, 0.45f, 1.0f);
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

