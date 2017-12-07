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
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import org.lwjgl.opengl.GL11;

import com.zhn.Remax.element.Element;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventRender3D;
import com.zhn.Remax.utils.IRenderer;
import com.zhn.Remax.utils.MathUtils;

@Element.ElementInfo(name="Wallhack", description="Flux-like WallHack.", bind=0, category=Element.Catergoy.RENDER, value=true, dName="Wallhack")
public class Wallhack
extends Element {
    int timer;

    @EventTarget
    public void onRender3D(EventRender3D event) {
        if (this.getState()) {
            for (Object obj : Minecraft.world.playerEntities) {
                if (!(obj instanceof EntityPlayer) || obj == Minecraft.player) continue;
                EntityPlayer entity = (EntityPlayer)obj;
                GL11.glPushMatrix();
                this.mc.getRenderManager();
                this.mc.getRenderManager();
                this.mc.getRenderManager();
                GlStateManager.translate(- RenderManager.renderPosX, - RenderManager.renderPosY, - RenderManager.renderPosZ);
                double x = entity.posX;
                double y = entity.posY + (double)entity.getEyeHeight() + 0.3;
                double z = entity.posZ;
                String color = "";
                if (entity.getHealth() >= 15.0f && entity.getHealth() <= 20.0f) {
                    color = " \u00a7a";
                } else if (entity.getHealth() >= 10.0f && entity.getHealth() < 15.0f) {
                    color = " \u00a76";
                } else if (entity.getHealth() >= 5.0f && entity.getHealth() < 10.0f) {
                    color = " \u00a7c";
                } else if (entity.getHealth() >= 0.0f && entity.getHealth() < 5.0f) {
                    color = " \u00a74";
                }
                String meme = "";
                String dank = "";
                if (!entity.isSneaking()) {
                    dank = "";
                } else if (entity.isSneaking()) {
                    dank = "\u00a76[S] ";
                }
                int kush = 17;
                int c = 0;
                if (!entity.isOnSameTeam(Minecraft.player)) {
                    c = new Color(255, 102, 0, 255).getRGB();
                } else if (entity.isOnSameTeam(Minecraft.player)) {
                    c = new Color(0, 166, 22, 255).getRGB();
                }
                this.renderNameTag(String.valueOf(color) + MathUtils.round(entity.getHealth(), 2), x, y, z, c);
                this.mc.getRenderManager();
                this.mc.getRenderManager();
                this.mc.getRenderManager();
                GlStateManager.translate(RenderManager.renderPosX, RenderManager.renderPosY, RenderManager.renderPosZ);
                GL11.glPopMatrix();
            }
        }
    }

    @EventTarget
    public void onRender3DDD(EventRender3D event) {
        for (Object obj : Minecraft.world.playerEntities) {
            if (!(obj instanceof EntityPlayer) || obj == Minecraft.player) continue;
            EntityPlayer entity = (EntityPlayer)obj;
            GL11.glPushMatrix();
            this.mc.getRenderManager();
            this.mc.getRenderManager();
            this.mc.getRenderManager();
            GlStateManager.translate(- RenderManager.renderPosX, - RenderManager.renderPosY, - RenderManager.renderPosZ);
            double x = entity.posX;
            double y = entity.posY + (double)entity.getEyeHeight() + 0.2;
            double z = entity.posZ;
            String color = "";
            if (entity.getHealth() >= 15.0f && entity.getHealth() <= 20.0f) {
                color = " \u00a7a";
            } else if (entity.getHealth() >= 10.0f && entity.getHealth() < 15.0f) {
                color = " \u00a76";
            } else if (entity.getHealth() >= 5.0f && entity.getHealth() < 10.0f) {
                color = " \u00a7c";
            } else if (entity.getHealth() >= 0.0f && entity.getHealth() < 5.0f) {
                color = " \u00a74";
            }
            String meme = "";
            String dank = "";
            if (!entity.isSneaking()) {
                dank = "";
            } else if (entity.isSneaking()) {
                dank = "\u00a76[S] ";
            }
            GL11.glPopMatrix();
        }
    }

    @EventTarget
    public void onRender3DD(EventRender3D event) {
        if (this.getState()) {
            for (Object obj : Minecraft.world.playerEntities) {
                if (!(obj instanceof EntityPlayer) || obj == Minecraft.player) continue;
                EntityPlayer entity = (EntityPlayer)obj;
                GL11.glPushMatrix();
                this.mc.getRenderManager();
                this.mc.getRenderManager();
                this.mc.getRenderManager();
                GlStateManager.translate(- RenderManager.renderPosX, - RenderManager.renderPosY, - RenderManager.renderPosZ);
                double x = entity.posX;
                double y = entity.posY + (double)entity.getEyeHeight() + 0.2;
                double z = entity.posZ;
                String color = "";
                if (entity.getHealth() >= 15.0f && entity.getHealth() <= 20.0f) {
                    color = " \u00a7a";
                } else if (entity.getHealth() >= 10.0f && entity.getHealth() < 15.0f) {
                    color = " \u00a76";
                } else if (entity.getHealth() >= 5.0f && entity.getHealth() < 10.0f) {
                    color = " \u00a7c";
                } else if (entity.getHealth() >= 0.0f && entity.getHealth() < 5.0f) {
                    color = " \u00a74";
                }
                String meme = "";
                String dank = "";
                if (!entity.isSneaking()) {
                    dank = "";
                } else if (entity.isSneaking()) {
                    dank = "\u00a76[S] ";
                }
                GL11.glPopMatrix();
            }
        }
    }

    public void renderNameTag(String tag, double pX, double pY, double pZ, int Color2) {
        if (this.getState()) {
            FontRenderer var12 = Minecraft.fontRendererObj;
            float var13 = (float)(Minecraft.player.getDistance(pX, pY, pZ) / 4.0);
            if (var13 < 1.6f) {
                var13 = 1.6f;
            }
            RenderManager renderManager = this.mc.getRenderManager();
            float scale = var13;
            scale /= 50.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)pX), (float)((float)pY + 0.3f), (float)((float)pZ));
            GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(- renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            Tessellator var14 = Tessellator.getInstance();
            BufferBuilder var15 = var14.getBuffer();
            int width = Minecraft.fontRendererObj.getStringWidth(tag) / 2;
            int kush = 17;
            boolean meme = false;
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glScalef((float)0.0165f, (float)0.0165f, (float)0.0165f);
            GL11.glEnable((int)2848);
            IRenderer.drawBorderRect(- kush - 2 - 18, - Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 2 - 5, kush + 2 + 18, -135, new Color(0, 0, 0, 255).getRGB(), new Color(0, 0, 0, 0).getRGB(), 1);
            IRenderer.drawBorderRect(- kush - 1 - 18, - Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 2 - 1 - 1 - 5 - 1, kush + 1 + 18, -132, Color2, new Color(0, 0, 0, 0).getRGB(), 3);
            IRenderer.drawBorderRect(- kush + 2 - 18, - Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 2 - 5 - 4, kush + 2 + 18 - 4, -131, new Color(0, 0, 0, 255).getRGB(), new Color(0, 0, 0, 0).getRGB(), 1);
            IRenderer.drawRect(- kush + 2 + 18 - 3 - 36, - Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 2 - 1 - 1 - 5 - 1 + 3, - kush + 2 + 18 - 36, -135.0f, Color2);
            GL11.glScalef((float)-1.0f, (float)-1.0f, (float)-1.0f);
            GlStateManager.enableTexture2D();
            GlStateManager.depthMask(true);
            GL11.glPushMatrix();
            GL11.glPopMatrix();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public void renderWhTag(String tag, double pX, double pY, double pZ) {
        if (this.getState()) {
            FontRenderer var12 = Minecraft.fontRendererObj;
            float var13 = (float)(Minecraft.player.getDistance(pX, pY, pZ) / 4.0);
            if (var13 < 1.6f) {
                var13 = 1.6f;
            }
            RenderManager renderManager = this.mc.getRenderManager();
            float scale = var13;
            scale /= 50.0f;
            GL11.glPushMatrix();
            GL11.glTranslatef((float)((float)pX), (float)((float)pY + 0.3f), (float)((float)pZ));
            GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)(- renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
            GL11.glRotatef((float)renderManager.playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glScalef((float)-0.033f, (float)-0.033f, (float)0.033f);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            Tessellator var14 = Tessellator.getInstance();
            BufferBuilder var15 = var14.getBuffer();
            int width = Minecraft.fontRendererObj.getStringWidth(tag) / 2;
            int kush = 17;
            GL11.glEnable((int)3042);
            GL11.glBlendFunc((int)770, (int)771);
            GlStateManager.enableTexture2D();
            GlStateManager.depthMask(true);
            Minecraft.fontRendererObj.drawString(tag, kush + 1, - Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 23 + 1, -1);
            GL11.glPushMatrix();
            GL11.glPopMatrix();
            GL11.glEnable((int)2896);
            GL11.glEnable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
            GL11.glPopMatrix();
        }
    }

    public void renderWhName(String tag, double pX, double pY, double pZ) {
        FontRenderer var12 = Minecraft.fontRendererObj;
        float var13 = (float)(Minecraft.player.getDistance(pX, pY, pZ) / 4.0);
        if (var13 < 1.6f) {
            var13 = 1.6f;
        }
        RenderManager renderManager = this.mc.getRenderManager();
        float scale = var13;
        scale /= 50.0f;
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)pX), (float)((float)pY + 0.3f), (float)((float)pZ));
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(- renderManager.playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)renderManager.playerViewX, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glScalef((float)-0.033f, (float)-0.033f, (float)0.033f);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        Tessellator var14 = Tessellator.getInstance();
        BufferBuilder var15 = var14.getBuffer();
        int width = Minecraft.fontRendererObj.getStringWidth(tag) / 2;
        int kush = 17;
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GlStateManager.enableTexture2D();
        GlStateManager.depthMask(true);
        Minecraft.fontRendererObj.drawString(" " + tag, kush + 1, - Minecraft.fontRendererObj.FONT_HEIGHT + 1 + 13 + 1, -1);
        GL11.glPushMatrix();
        GL11.glPopMatrix();
        GL11.glEnable((int)2896);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glColor4f((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    @Override
    public String getValue() {
        return "Vanilla";
    }
}

