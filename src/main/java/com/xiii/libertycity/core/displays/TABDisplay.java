package com.xiii.libertycity.core.displays;

import java.util.Collection;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TABDisplay {

    public void removePlayers(Player receiver) {
        Collection<? extends Player> playersBukkit = Bukkit.getOnlinePlayers();
        EntityPlayer[] playersNMS = new EntityPlayer[playersBukkit.size()];
        int current = 0;
        for (Player player : playersBukkit) {
            playersNMS[current] = ((CraftPlayer) player).getHandle();
            current++;
        }
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.REMOVE_PLAYER, playersNMS);
        ((CraftPlayer) receiver).getHandle().playerConnection.sendPacket(packet);
    }

    public EntityPlayer createPlayers(String name, String listName, String texture, String signature) {
        MinecraftServer server = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer worldserver = server.getWorldServer(0);
        PlayerInteractManager playerinteractmanager = new PlayerInteractManager(worldserver);
        GameProfile profile = new GameProfile(UUID.randomUUID(), name);
        profile.getProperties().put("textures", new Property("textures", texture, signature));
        EntityPlayer player = new EntityPlayer(server, worldserver, profile, playerinteractmanager);
        player.listName = new ChatComponentText(listName);
        return player;
    }

    public void addPlayers(Player receiver, EntityPlayer... createdPlayers) {
        PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(EnumPlayerInfoAction.ADD_PLAYER, createdPlayers);
        ((CraftPlayer) receiver).getHandle().playerConnection.sendPacket(packet);
    }

}
