package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearInv implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("clear") || command.getName().equalsIgnoreCase("ci")) {
            if(sender.hasPermission("LibertyCity.clear")) {
                if(args.length < 1) {
                    Bukkit.getPlayer(String.valueOf(sender)).getInventory().clear();
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fVotre inventaire a été néttoyé");
                } else if(args.length == 1) {
                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    if(sender.hasPermission("LibertyCity.clear.others")) {
                        if(target.isOnline()) {
                            Bukkit.getPlayer(String.valueOf(target)).getInventory().clear();
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fInventaire de §6" + target.getName() + " §fnéttoyé");
                            target.sendMessage("§2§lLiberty§a§lCity §7» §fVotre inventaire a été néttoyé");
                        } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Ce joueur n'est pas en ligne");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                } else if(args.length > 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }

        return false;
    }
}
