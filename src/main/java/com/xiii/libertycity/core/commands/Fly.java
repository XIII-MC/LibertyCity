package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (command.getName().equalsIgnoreCase("fly")) {
                if (sender.hasPermission("LibertyCity.fly")) {
                    if (args.length < 1) {
                        if (!player.getAllowFlight()) {
                            player.setAllowFlight(true);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly §a§nactivé");
                        } else {
                            player.setAllowFlight(false);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly §c§ndésactivé");
                        }
                    } else if (args.length == 1) {
                        if (Bukkit.getServer().getPlayer(args[0]) != null) {
                            Player target = Bukkit.getServer().getPlayer(args[0]);
                            if (sender.hasPermission("LibertyCity.fly.others")) {
                                if (!target.getAllowFlight()) {
                                    target.setAllowFlight(true);
                                    target.sendMessage("§2§lLiberty§a§lCity §7» §fFly §a§nactivé");
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly pour §6" + target.getName() + "§a§nactivé");
                                } else {
                                    target.setAllowFlight(false);
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly §c§ndésactivé");
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly pour §6" + target.getName() + "§c§ndésactivé");
                                }
                            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                        }
                    }
                } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
            }
        }
        return true;
    }
}
