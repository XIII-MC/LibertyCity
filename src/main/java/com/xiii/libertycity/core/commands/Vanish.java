package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Vanish implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("vanish") || command.getName().equalsIgnoreCase("v")) {
            if(sender.hasPermission("LibertyCity.vanish")) {
                PlayerData data = Data.data.getUserData((Player) sender);
                if(data.isVanished) {
                    data.isVanished = false;
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        p.hidePlayer((Player) sender);
                        if(p.hasPermission("LibertyCity.vanish.seeothers")) p.showPlayer((Player) sender);
                        if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7est désormais invisible");
                    }
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais invisible");
                } else {
                    data.isVanished = true;
                    for(Player p : Bukkit.getOnlinePlayers()) {
                        p.showPlayer((Player) sender);
                        if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7n'est plus invisible");
                    }
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous n'êtes plus invisible");
                }
            }
        }

        return true;
    }

    @EventHandler
    public void joinMoment(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            for(Player p : Bukkit.getOnlinePlayers()) {
                PlayerData data = Data.data.getUserData(p);
                if(!data.isVanished) p.showPlayer(p);
                if(data.isVanished) {
                    if(p.hasPermission("LibetyCity.vanish.seeothers")) p.showPlayer(p);
                }
            }

        });
    }
}
