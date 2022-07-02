package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("tp") || command.getName().equalsIgnoreCase("teleport")) {
            if(sender.hasPermission("LibertyCity.teleport")) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                Player target2 = Bukkit.getServer().getPlayer(args[1]);
                if(args.length < 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! /tp <Joueur> (Joueur)");
                if(args.length == 1) {
                    if(target.isOnline()) {
                        Bukkit.getPlayer(String.valueOf(sender)).teleport(target);
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été téléporté a §6" + target.getName());
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Ce joueur n'est pas en ligne");
                } else if(args.length == 2) {
                    if(target.isOnline() && target2.isOnline()) {
                        Bukkit.getPlayer(String.valueOf(target)).teleport(target2);
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez téléporté §6" + target.getName() + " §fà §6" + target2.getName());
                        target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été téléporté à §6" + target2.getName());
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Un des joueurs n'est pas en ligne");
                } else if(args.length > 2) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }

        return false;
    }
}
