package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Feed implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("feed")) {
            if(sender.hasPermission("LibertyCity.feed")) {
                if(args.length < 1) {
                    Bukkit.getPlayer(String.valueOf(sender)).setFoodLevel(20);
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rassasié");
                } else if(args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(sender.hasPermission("LibertyCity.feed.others")) {
                        if (target.isOnline()) {
                            Bukkit.getPlayer(String.valueOf(target)).setFoodLevel(20);
                            target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rassasié");
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + " §fa été rassasié");
                        } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Ce joueur n'est pas en ligne");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante");
                }
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante");
        }

        return false;
    }
}
