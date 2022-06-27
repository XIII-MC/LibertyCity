package com.xiii.libertycity.core;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.player.DB;
import com.xiii.libertycity.core.data.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            DB.data.registerUserJoin(e.getPlayer());
            PlayerData data = DB.data.getUserData(e.getPlayer());

            Bukkit.broadcastMessage(e.getPlayer() + "A REJOINT AVEC VARS -> " + data.rpNom + " " + data.rpPrenom + " " + data.rpAge + " " + data.playerID);

            if(data.playerID > -1) {
                if (!e.getPlayer().hasPermission("LibertyCity.silent.quit")) {
                    e.setJoinMessage("§2» §a" + data.rpPrenom + " §2" + data.rpNom + " §7(" + e.getPlayer() + "§7)");

                } else {
                    e.setJoinMessage("");
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if(p.hasPermission("LibertyCity.silent.quit.alerts")) {
                            p.sendMessage("§4§LSTAFF §7» §8" + e.getPlayer().getName() + " §7rejoint le serveur.");
                        }
                    }
                }
            } else {
                e.setJoinMessage("");
            }

        });
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            DB.data.registerUserJoin(e.getPlayer());
            PlayerData data = DB.data.getUserData(e.getPlayer());

            if(data.playerID > -1) {
                if (!e.getPlayer().hasPermission("LibertyCity.silent.join")) {
                    e.setQuitMessage("§c» §a" + data.rpPrenom + " §2" + data.rpNom + " §7(" + e.getPlayer() + "§7)");

                } else {
                    e.setQuitMessage("");
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if(p.hasPermission("LibertyCity.silent.join.alerts")) {
                            p.sendMessage("§4§LSTAFF §7» §8" + e.getPlayer() + " §7a quitté le serveur.");
                        }
                    }
                }
            } else {
                e.setQuitMessage("");
            }

        });
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            if(e.getMessage().contains("calc")) {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(p.hasPermission("LibertyCity.anticheat.alerts")) p.sendMessage("§7[§4⚠§7] §f" + e.getPlayer().getName() + " §7failed §fCrasher §7(A)");
                }
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "/kick "+ e.getPlayer().getName() + " Triche -s");
                e.setCancelled(true);
            }

        });
    }

    @EventHandler
    public void onRestrictedInventory(InventoryOpenEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            if(e.getInventory().getName().contains("Player") || e.getInventory().getName().contains("Anvil")) {
                if(!e.getPlayer().hasPermission("LibertyCity.bypass.inventory")) {
                    e.setCancelled(true);
                    e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cLes crafts/enclumes sont désactivés !");
                }
            }

        });
    }

}
