package com.xiii.libertycity.core.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

import static org.bukkit.Bukkit.getServer;

public class Kick implements CommandExecutor {

    String kickReason;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("kick")) {
            if (sender.hasPermission("LibertyCity.kick.use")) {
                if (args.length == 0) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Usage: /kick [JOUEUR] (RAISON) (-s)");
                    return true;
                } else {
                    Player player = (Player) sender;
                    Player target = getServer().getPlayer(args[0]);
                    if(args.length == 1) {
                        target.kickPlayer("§2§lLiberty§a§lCity §7» §cVous avez été explusé du serveur.");
                        Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été explusé du serveur par §c" + player.getName());
                        Bukkit.getConsoleSender().sendMessage("[LOG] " + player.getName() + ": /kick " + target.getName());
                        return true;
                    } else if(args.length > 1) {
                        if(args[2].contains("-s")) {
                            kickReason.replace("-s", "");
                            if(args.length > 2) {
                                target.kickPlayer("§2§lLiberty§a§lCity §7» §cVous avez été explusé du serveur, " + kickReason);
                                player.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été explusé du serveur, §c" + kickReason);
                                Bukkit.getConsoleSender().sendMessage("[LOG] " + player.getName() + ": /kick " + target.getName());
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.kick.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + player.getName() + " §7a explusé §8" + target.getName() + " §7, " + kickReason);
                                }
                                return true;
                            } else if(args.length == 2) {
                                kickReason = args[2];
                                target.kickPlayer("§2§lLiberty§a§lCity §7» §cVous avez été explusé du serveur.");
                                player.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été explusé du serveur.");
                                Bukkit.getConsoleSender().sendMessage("[LOG] " + player.getName() + ": /kick " + target.getName());
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.kick.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + player.getName() + " §7a explusé §8" + target.getName());
                                }
                                return true;
                            }
                        } else {
                            if(args.length > 1) {
                                kickReason = args[2];
                                target.kickPlayer("§2§lLiberty§a§lCity §7» §cVous avez été explusé du serveur, " + kickReason);
                                player.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été explusé du serveur, §c" + kickReason);
                                Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été explusé du serveur par §c" + player.getName() + "§f, " + args);
                                Bukkit.getConsoleSender().sendMessage("[LOG] " + player + ": /kick " + target.getName());
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
