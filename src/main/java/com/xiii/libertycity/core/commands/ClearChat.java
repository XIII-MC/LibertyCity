package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("clearchat") || command.getName().equalsIgnoreCase("cc") || command.getName().equalsIgnoreCase("chatclear")) {
            if(sender.hasPermission("LibertyCity.chatclear.use")) {
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(!p.hasPermission("LibertyCity.chatclear.bypass")) {
                        for(int i = 0; i < 200; i++) {
                            p.sendMessage("§B§2§3§A§L§O");
                        }
                    } else {
                        p.sendMessage("§2§lLiberty§a§lCity §7» §7§OVotre chat n'a pas été néttoyé grâce a vos permissions.");
                    }
                }
                Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat a été néttoyé !");
                for(Player p : Bukkit.getOnlinePlayers()) {
                    if(p.hasPermission("LibertyCity.chatclear.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a néttoyé le chat.");
                }
                return true;
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }

        return false;
    }
}
