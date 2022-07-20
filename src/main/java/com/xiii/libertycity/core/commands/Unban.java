package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Unban implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("unban")) {
            if(sender.hasPermission("LibertyCity.command.unban")) {
                if (args.length < 1) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! /unban <Joueur> (Raison) (-s)");
                    return true;
                } else if (args.length >= 1) {
                    Player target = getServer().getPlayer(args[0]);
                    PlayerData data = Data.data.getUserData(target);
                    String unbanReason = "";
                    for (int i = 1; i < args.length; i++) {
                        unbanReason += args[i] + " ";
                    }
                    String newStringConverted = "";
                    newStringConverted = unbanReason.replace("-s", "");
                    if (args.length == 1) {
                        if (data.isBanned) {
                            data.isBanned = false;
                            Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été débanni");
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                if (p.hasPermission("LibertyCity.staff.alerts"))
                                    p.sendMessage("§4LSTAFF §7» §8" + target.getName() + " §7a été débanni par §8" + sender.getName());
                            }
                            return true;
                        } else {
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce joueur n'est pas banni");
                            return true;
                        }
                    } else if (args.length > 1) {
                        if (unbanReason.contains("-s")) {
                            if (args.length > 2) {
                                if (data.isBanned) {
                                    data.isBanned = false;
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été débanni, §6" + newStringConverted);
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("LibertyCity.staff.alerts"))
                                            p.sendMessage("§4§LSTAFF §7» §8" + target.getName() + " §7a été débanni par §8" + sender.getName() + " §7, §8" + newStringConverted);
                                    }
                                    return true;
                                } else {
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce joueur n'est pas banni");
                                    return true;
                                }
                            } else if (args.length == 2) {
                                if (data.isBanned) {
                                    data.isBanned = false;
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été débanni.");
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("LibertyCity.staff.alerts"))
                                            p.sendMessage("§4§LSTAFF §7» §8" + target.getName() + " §7a été débanni par §8" + sender.getName());
                                    }
                                    return true;
                                } else {
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce joueur n'est pas banni");
                                    return true;
                                }
                            }
                        } else {
                            if (args.length > 1) {
                                if (data.isBanned) {
                                    data.isBanned = false;
                                    Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été débanni, §c" + newStringConverted);
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("LibertyCity.staff.alerts"))
                                            p.sendMessage("§4§LSTAFF §7» §8" + target.getName() + " §7a été débanni par §8" + sender.getName() + " §7, §8" + newStringConverted);
                                    }
                                    return true;
                                } else {
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce joueur n'est pas banni");
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else if(sender instanceof Player) sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission insufisante.");
        }

        return false;
    }
}
