package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import com.xiii.libertycity.core.utils.ConvertUtil;
import com.xiii.libertycity.core.utils.TimeUtil;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mute implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("mute")) {
            if(sender.hasPermission("LibertyCity.command.mute")) {

                if(args.length > 0) {

                    Player target = Bukkit.getServer().getPlayer(args[0]);
                    PlayerData data = Data.data.getUserData(target);

                    if(target.isOnline()) {
                        data.isMuted = true;
                        data.muteTime = TimeUtil.getDate();
                        data.muteReason = "§cNon Specifiée.";
                        data.muteCalc = System.currentTimeMillis();
                        if (args.length == 2) {
                            if (args[1].equalsIgnoreCase("perm")) {
                                if (args.length == 2) {
                                    target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée §cindéterminé");
                                    Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été rendu muet pour une durée §cindéterminé");
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " a été rendu muet pour une durée §6indéterminé");
                                    for(Player p : Bukkit.getOnlinePlayers()) {
                                        if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §8» " + target.getName() + " a été rendu muet pour une durée §8indéterminé §7par §8" + sender.getName());
                                    }
                                } else if(args.length > 2) {

                                    String muteReason = "";
                                    for (int i = 1; i < args.length; i++) {
                                        muteReason += args[i] + " ";
                                    }
                                    String newStringConverted = "";
                                    newStringConverted = muteReason.replace("-s", "");

                                    data.muteReason = newStringConverted;

                                    if(muteReason.contains("-s")) {
                                        target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée §cindéterminé§f, §c" + newStringConverted);
                                        sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " a été rendu muet pour une durée §6indéterminé§f, §6" + newStringConverted);
                                        for(Player p : Bukkit.getOnlinePlayers()) {
                                            if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §8» " + target.getName() + " a été rendu muet pour une durée §8indéterminé §7par §8" + sender.getName() + "§7, §8" + newStringConverted);
                                        }
                                    } else {
                                        target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée §cindéterminé§f, §c" + newStringConverted);
                                        Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été rendu muet pour une durée §cindéterminé§f, §c" + newStringConverted);
                                        sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " a été rendu muet pour une durée §6indéterminé§f, §c" + newStringConverted);
                                        for(Player p : Bukkit.getOnlinePlayers()) {
                                            if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §8» " + target.getName() + " a été rendu muet pour une durée §8indéterminé §7par §8" + sender.getName() + "§7, §8" + newStringConverted);
                                        }
                                    }
                                }
                            } else {

                                long muteTimestamp = 0;
                                final String time;
                                time = args[1];
                                try {
                                    muteTimestamp = ConvertUtil.parseDateDiff(time, true);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }


                                data.muteDuration = muteTimestamp;
                                data.muteLeft = TimeUtil.getDate() + muteTimestamp;
                                if (args.length == 2) {
                                    target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée de §c" + muteTimestamp);
                                    Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été rendu muet pour une durée de §c" + muteTimestamp);
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " a été rendu muet pour une durée de §c" + muteTimestamp);
                                    for(Player p : Bukkit.getOnlinePlayers()) {
                                        if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §8» " + target.getName() + " a été rendu muet pour une durée de §8" + muteTimestamp + "§7par §8" + sender.getName());
                                    }
                                } else if(args.length > 2) {

                                    String muteReason = "";
                                    for (int i = 1; i < args.length; i++) {
                                        muteReason += args[i] + " ";
                                    }
                                    String newStringConverted = "";
                                    newStringConverted = muteReason.replace("-s", "");

                                    data.muteReason = newStringConverted;

                                    if(muteReason.contains("-s")) {
                                        target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée de §c" + muteTimestamp + "§f, §c" + newStringConverted);
                                        sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " a été rendu muet pour une durée de §c" + muteTimestamp + "§f, §c" + newStringConverted);
                                        for(Player p : Bukkit.getOnlinePlayers()) {
                                            if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §8» " + target.getName() + " a été rendu muet pour une durée de §8" + muteTimestamp + "§7par §8" + sender.getName() + "§7, §8" + newStringConverted);
                                        }
                                    } else {
                                        target.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée de §c" + muteTimestamp + "§f, §c" + newStringConverted);
                                        Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été rendu muet pour une durée de §c" + muteTimestamp + "§f, §c" + newStringConverted);
                                        sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " a été rendu muet pour une durée de §c" + muteTimestamp + "§f, §c" + newStringConverted);
                                        for(Player p : Bukkit.getOnlinePlayers()) {
                                            if(p.hasPermission("LibertyCity.staff")) p.sendMessage("§4§LSTAFF §8» " + target.getName() + " a été rendu muet pour une durée de §8" + muteTimestamp + "§7par §8" + sender.getName() + "§7, §8" + newStringConverted);
                                        }
                                    }
                                }

                            }
                        }
                    } else {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Ce joueur n'est pas en ligne !");
                    }
                } else {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Usage: /mute <Joueur> <Temps/Perm> (Raison) (-s)");
                }

            } else {
                sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
            }
        }

        return true;
    }
}
