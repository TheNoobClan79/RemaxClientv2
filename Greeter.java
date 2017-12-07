package com.zhn.Remax.element.elements;

import com.mojang.authlib.GameProfile;
import com.zhn.Remax.ClientInterface;
import com.zhn.Remax.element.Element;
import com.zhn.Remax.element.Element.Catergoy;
import com.zhn.Remax.element.Element.ElementInfo;
import com.zhn.Remax.event.EventTarget;
import com.zhn.Remax.event.events.EventUpdate;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetHandlerPlayClient;
import net.minecraft.client.network.NetworkPlayerInfo;

@Element.ElementInfo(name="Greeter", description="Says a random message to a player when they leave or join", category=Element.Catergoy.MISC, bind=0, value=false, dName="Greeter")
public class Greeter
  extends Element
{
  public static boolean active;
  static ArrayList<NetworkPlayerInfo> playerMap = new ArrayList();
  static int cachePlayerCount;
  boolean isOnServer;
  public static ArrayList<String> greets = new ArrayList();
  public static ArrayList<String> goodbyes = new ArrayList();
  static String[] insults;
  
  @EventTarget
  public void onUpdate(EventUpdate event)
  {
    if ((getState()) && (Minecraft.player != null)) {
      if (Minecraft.player.ticksExisted % 10 == 0) {
        checkPlayers();
      } else if ((this.mc.isSingleplayer()) || (this.mc.getCurrentServerData() == null)) {
        toggle();
      }
    }
  }
  
  private void checkPlayers()
  {
    ArrayList<NetworkPlayerInfo> infoMap = new ArrayList(
      Minecraft.getMinecraft().getConnection().getPlayerInfoMap());
    
    int currentPlayerCount = infoMap.size();
    if (currentPlayerCount != cachePlayerCount)
    {
      ArrayList<NetworkPlayerInfo> currentInfoMap = (ArrayList)infoMap.clone();
      currentInfoMap.removeAll(playerMap);
      if (currentInfoMap.size() > 5)
      {
        cachePlayerCount = playerMap.size();
        onJoinServer();
        return;
      }
      ArrayList<NetworkPlayerInfo> playerMapClone = (ArrayList)playerMap.clone();
      playerMapClone.removeAll(infoMap);
      for (NetworkPlayerInfo npi : currentInfoMap) {
        playerJoined(npi);
      }
      for (NetworkPlayerInfo npi : playerMapClone) {
        playerLeft(npi);
      }
      cachePlayerCount = playerMap.size();
      onJoinServer();
    }
  }
  
  private void onJoinServer()
  {
    playerMap = new ArrayList(Minecraft.getMinecraft().getConnection().getPlayerInfoMap());
    cachePlayerCount = playerMap.size();
    this.isOnServer = true;
  }
  
  protected void playerJoined(NetworkPlayerInfo playerInfo)
  {
    boolean send = true;
    if (send)
    {
      String[] join = { "Oh, You're back again " + playerInfo.getGameProfile().getName() + "?", 
        "Good to see you again, " + playerInfo.getGameProfile().getName() + "!", 
        "Aww, it's you " + playerInfo.getGameProfile().getName(), 
        "Good evening, " + playerInfo.getGameProfile().getName(), 
        "Nice to see you " + playerInfo.getGameProfile().getName() };
      Random random = new Random();
      Minecraft.getMinecraft();
      String iteminhand = Minecraft.player.getHeldEquipment().toString();
      int index = random.nextInt(join.length);
      String chat = join[index];
      Minecraft.getMinecraft();
      Minecraft.player.sendChatMessage("> " + chat + ". | Make sure to Join The Town Lodges! https://discord.gg/A4j9SHC |");
    }
  }
  
  protected void playerLeft(NetworkPlayerInfo playerInfo)
  {
    boolean send = true;
    if (send)
    {
      String[] join = { "Well, It was nice to have you here, " + playerInfo.getGameProfile().getName(), 
        "Bye, Bye " + playerInfo.getGameProfile().getName(), 
        "Hope you had a good time, " + playerInfo.getGameProfile().getName() };
      Random random = new Random();
      Minecraft.getMinecraft();
      String iteminhand = Minecraft.player.getHeldEquipment().toString();
      int index = random.nextInt(join.length);
      String chat = join[index];
      Minecraft.getMinecraft();
      Minecraft.player.sendChatMessage("> " + chat + ". | Make sure to Join The Town Lodges! https://discord.gg/A4j9SHC |");
    }
  }
  
  public void onDisable()
  {
    super.onDisable();
    active = false;
  }
  
  public void onEnable()
  {
    super.onEnable();
    ClientInterface.addChatMessage("§4Warning: turn off Greeter before you leave the server.", Boolean.valueOf(true));
    active = true;
  }
  
  public String getValue()
  {
    return null;
  }
}
