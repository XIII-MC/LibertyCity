package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.ServerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CooldownChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("cooldownchat") || command.getName().equalsIgnoreCase("cdchat")) {
            if(sender.hasPermission("LibertyCity.cooldownchat.use")) {
                ServerData server = Data.data.getServerData(Bukkit.getServer());

                if(args.length == 0) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Usage: /cooldownchat [TEMPS] (NB: Temps en MS)");
                } else if(args.length >= 1) {
                    int newIntConverted = 0;
                    newIntConverted = Integer.parseInt(args[0]);
                    assert server != null;
                    if(newIntConverted == server.chatCooldownGlobal) {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Le cooldown est déja a §6" + newIntConverted + "§6ms");
                    } else {
                        server.chatCooldownGlobal = newIntConverted;
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fLe cooldown est désormais à §6" + newIntConverted + "§6ms");
                        for(Player p : Bukkit.getOnlinePlayers()) {
                            if(p.hasPermission("LibertyCity.cooldownchat.use")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7à mis le cooldown pour le chat §8GLOBAL §7à §8" + newIntConverted + "§8ms");
                        }
                    }
                }
                return true;
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }
    return false;
    }
}
