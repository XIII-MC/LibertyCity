package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.LibertyCity;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Spawn implements CommandExecutor {

    Location spawn = new Location(Bukkit.getWorld("world"), -1244, 86, 14.313);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("spawn")) {
            if(sender.hasPermission("LibertyCity.spawn")) {
                if(args.length == 0) {
                    Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {
                       Player p = (Player) sender;
                       p.teleport(spawn);
                       p.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été téléporté au §6Spawn§f.");
                    });
                    return true;
                } else if(args.length == 1) {
                    Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {
                       Player p = getServer().getPlayer(args[0]);
                       p.teleport(spawn);
                       p.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été téléporté au §eSpawn§f.");
                       sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + p.getName() + "a été téléporté au §6Spawn§f.");
                    });
                    return true;
                } else if(args.length > 1) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Il y a trop d'aguments.");
                    return true;
                }
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }

        return false;
    }
}
