package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TimeSet implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("day")) {
            if(sender.hasPermission("LibertyCity.time.day")) {
                Bukkit.getPlayer(String.valueOf(sender)).getWorld().setFullTime(0);
                sender.sendMessage("§2§lLiberty§a§lCity §7» §fHeure mise à §eJour");
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(p.hasPermission("LibertyCity.staff")) {
                        p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a mis l'heure à §8Jour");
                    }
                }
            }
        }

        if(command.getName().equalsIgnoreCase("night")) {
            if(sender.hasPermission("LibertyCity.time.night")) {
                Bukkit.getPlayer(String.valueOf(sender)).getWorld().setFullTime(12000);
                sender.sendMessage("§2§lLiberty§a§lCity §7» §fHeure mise à §eNuit");
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(p.hasPermission("LibertyCity.staff")) {
                        p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a mis l'heure à §8Nuit");
                    }
                }
            }
        }

        return false;
    }
}
