package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("fly")) {
            if(sender.hasPermission("LibertyCity.fly")) {
                if(args.length < 1) {
                    if(Bukkit.getPlayer(String.valueOf(sender)).getAllowFlight()) {
                        Bukkit.getPlayer(String.valueOf(sender)).setAllowFlight(false);
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly §a§nactivé");
                    } else {
                        Bukkit.getPlayer(String.valueOf(sender)).setAllowFlight(true);
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly §c§ndésactivé");
                    }
                } else if(args.length == 1) {
                    Player target = getServer().getPlayer(args[0]);
                    if(sender.hasPermission("LibertyCity.fly.others")) {
                        if(Bukkit.getPlayer(String.valueOf(target)).getAllowFlight()) {
                            Bukkit.getPlayer(String.valueOf(target)).setAllowFlight(false);
                            target.sendMessage("§2§lLiberty§a§lCity §7» §fFly §a§nactivé");
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly pour §6" + target.getName() + "§a§nactivé");
                        } else {
                            Bukkit.getPlayer(String.valueOf(target)).setAllowFlight(true);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly §c§ndésactivé");
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fFly pour §6" + target.getName() + "§c§ndésactivé");
                        }
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                 }
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }

        return false;
    }
}
