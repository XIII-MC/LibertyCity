package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Report implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("report")) {
            PlayerData data = Data.data.getUserData((Player) sender);

            if(System.currentTimeMillis() - data.lastReport >= 30000) {
                Player target = getServer().getPlayer(args[0]);
                PlayerData temp = Data.data.getUserData(target);

                if(!target.isOnline()) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Ce joueur n'est pas en ligne");
                    return true;
                } else {
                    data.lastReport = System.currentTimeMillis();
                    if(args.length == 1) {
                        for(Player p : Bukkit.getOnlinePlayers()) {
                            if(p.hasPermission("LibertyCity.reports.see")) {
                                p.sendMessage(" ");
                                p.sendMessage("§c=-=-=-=-=-= §4§lREPORT §c=-=-=-=-=-=");
                                p.sendMessage(" ");
                                p.sendMessage("     §a" + sender.getName() + " §7(" + data.rpPoliceRank + " " + data.rpNom + "§7) a signlé(e) §c" + target.getName() + " §7(" + temp.rpPrenom + " " + temp.rpNom + "§7)");
                                p.sendMessage("     §7Raison » §cNon Spécifiée.");
                                p.sendMessage(" ");
                                p.sendMessage("§c=-=-=-=-=-= §4§lREPORT §c=-=-=-=-=-=");
                                p.sendMessage(" ");
                            }
                        }
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fVotre signalement a bien été transmis.");
                        return true;
                    } else if(args.length > 1) {
                        String reportReason = "";
                        for (int i = 1; i < args.length; i++) {
                            reportReason += args[i] + " ";
                        }
                        for(Player p : Bukkit.getOnlinePlayers()) {
                            if(p.hasPermission("LibertyCity.reports.see")) {
                                p.sendMessage(" ");
                                p.sendMessage("§c=-=-=-=-=-= §4§lREPORT §c=-=-=-=-=-=");
                                p.sendMessage(" ");
                                p.sendMessage("     §a" + sender.getName() + " §7(" + data.rpPoliceRank + " " + data.rpNom + "§7) a signlé(e) §c" + target.getName() + " §7(" + temp.rpPrenom + " " + temp.rpNom + "§7)");
                                p.sendMessage("     §7Raison » §c" + reportReason);
                                p.sendMessage(" ");
                                p.sendMessage("§c=-=-=-=-=-= §4§lREPORT §c=-=-=-=-=-=");
                                p.sendMessage(" ");
                            }
                        }
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fVotre signalement a bien été transmis.");
                        return true;
                    }
                }
            } else {
                sender.sendMessage("§2§lLiberty§a§lCity §7» §fVeuillez patienter entre chaque signalement.");
                return true;
            }
        }

        return false;
    }
}
