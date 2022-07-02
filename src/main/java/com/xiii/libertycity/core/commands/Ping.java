package com.xiii.libertycity.core.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static com.xiii.libertycity.core.utils.PingUtil.getPing;

public class Ping implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("ping")) {
            sender.sendMessage("§2§lLiberty§a§lCity §7» §fCalcule en cours...");
            Player player = (Player) sender;
            try {
                sender.sendMessage("§2§lLiberty§a§lCity §7» §fVotre connection au serveur a un délai de §6" + getPing(player) + "§ems");
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
