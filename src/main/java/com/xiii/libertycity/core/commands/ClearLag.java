package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.List;

public class ClearLag implements CommandExecutor {

    int cItemsAmount = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender.hasPermission("LibertyCity.command.clearlag")) {
            if(command.getName().equalsIgnoreCase("clearlag")) {
                World world = Bukkit.getServer().getWorld("world");
                List<Entity> entList = world.getEntities();
                for(Entity current : entList) {
                    if (current.getType() == EntityType.DROPPED_ITEM) {
                        cItemsAmount++;
                        current.remove();
                    }
                }
                if(sender instanceof Player) sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + cItemsAmount + " §fentitées retirées.");
                return true;
            }
        } else if(sender instanceof Player) sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission insufisante.");

        return false;
    }
}
