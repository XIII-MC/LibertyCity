package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Kick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("kick")) {
            if (sender.hasPermission("LibertyCity.kick.use")) {
                if (args.length == 0) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Usage: /kick [JOUEUR] (RAISON) (-s)");
                    return true;
                } else {
                    Player target = getServer().getPlayer(args[0]);
                    if(!target.isOnline()) {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Le joueur n'est pas en ligne !");
                    } else {
                        if (args.length == 1) {
                            target.kickPlayer("§7§m---------------§r§2§lLiberty§a§lCity§r§7§m---------------" + "\n" + "§cVous avez été explusé(e) du serveur!" + "\n" + " " + "\n" + "§7Raison: §eNon Spécifiée." + "\n" + "§7Temps restant: §cAucun." + "\n" + " " + "\n" + "§bPour contester cette sanction, veuillez utiliser le Discord:" + "\n" + "§4§nSanction non-contestable." + "\n" + "§7§m----------------------------------------");
                            Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été explusé du serveur");
                            //Bukkit.getConsoleSender().sendMessage("[LOG] " + sender.getName() + ": /kick " + target.getName());
                            return true;
                        } else if (args.length > 1) {
                            String kickReason = "";
                            for (int i = 1; i < args.length; i++) {
                                kickReason += args[i] + " ";
                            }
                            String newStringConverted = "";
                            newStringConverted = kickReason.replace("-s", "");
                            if (kickReason.contains("-s")) {
                                if (args.length > 2) {
                                    target.kickPlayer("§7§m---------------§r§2§lLiberty§a§lCity§r§7§m---------------" + "\n" + "§cVous avez été explusé(e) du serveur!" + "\n" + " " + "\n" + "§7Raison: §e" + newStringConverted + "\n" + "§7Temps restant: §cAucun." + "\n" + " " + "\n" + "§bPour contester cette sanction, veuillez utiliser le Discord:" + "\n" + "§4§nSanction non-contestable." + "\n" + "§7§m----------------------------------------");
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été explusé du serveur, §c" + newStringConverted);
                                    //Bukkit.getConsoleSender().sendMessage("[LOG] " + sender.getName() + ": /kick " + target.getName());
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("LibertyCity.kick.alerts"))
                                            p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a explusé §8" + target.getName() + " §7, " + newStringConverted);
                                    }
                                    return true;
                                } else if (args.length == 2) {
                                    target.kickPlayer("§7§m---------------§r§2§lLiberty§a§lCity§r§7§m---------------" + "\n" + "§cVous avez été explusé(e) du serveur!" + "\n" + " " + "\n" + "§7Raison: §e" + newStringConverted + "\n" + "§7Temps restant: §cAucun." + "\n" + " " + "\n" + "§bPour contester cette sanction, veuillez utiliser le Discord:" + "\n" + "§4§nSanction non-contestable." + "\n" + "§7§m----------------------------------------");
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été explusé du serveur.");
                                    //Bukkit.getConsoleSender().sendMessage("[LOG] " + sender.getName() + ": /kick " + target.getName());
                                    for (Player p : Bukkit.getOnlinePlayers()) {
                                        if (p.hasPermission("LibertyCity.kick.alerts"))
                                            p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a explusé §8" + target.getName());
                                    }
                                    return true;
                                }
                            } else {
                                if (args.length > 1) {
                                    target.kickPlayer("§7§m---------------§r§2§lLiberty§a§lCity§r§7§m---------------" + "\n" + "§cVous avez été explusé(e) du serveur!" + "\n" + " " + "\n" + "§7Raison: §e" + newStringConverted + "\n" + "§7Temps restant: §cAucun." + "\n" + " " + "\n" + "§bPour contester cette sanction, veuillez utiliser le Discord:" + "\n" + "§4§nSanction non-contestable." + "\n" + "§7§m----------------------------------------");
                                    sender.sendMessage("§2§lLiberty§a§lCity §7» §e" + target.getName() + " §fa été explusé du serveur, §c" + newStringConverted);
                                    Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §c" + target.getName() + " §fa été explusé du serveur par §f, §c" + newStringConverted);
                                    //Bukkit.getConsoleSender().sendMessage("[LOG] " + player + ": /kick " + target.getName());
                                    return true;
                                }
                            }
                        }
                    }
                }
            } else if(sender instanceof Player) sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission insufisante.");
        }

        return false;
    }
}
