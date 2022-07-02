package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("heal")) {
            if(sender.hasPermission("LibertyCity.heal")) {
                if(args.length < 1) {
                    player.setHealth(20);
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été soigné");
                } else if(args.length == 1) {
                    if(sender.hasPermission("LibertyCity.heal.others")) {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if(target.isOnline()) {
                            target.setHealth(20);
                            target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été soigné");
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + " §fa été soigné");
                        } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Ce joueur n'est pas en ligne");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante");
                }
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante");
        }

        return true;
    }
}
