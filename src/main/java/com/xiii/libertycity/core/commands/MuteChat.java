package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    /*@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("mutechat")) {
            if(sender.hasPermission("LibertyCity.mutechat.use")) {
                ServerData sData = com.xiii.libertycity.core.data.server.Data.sData.getServerData(Bukkit.getServer());

                if(args.length == 0) {
                    if (sData.chatStateGlobal) {
                        sData.chatStateGlobal = false;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.hasPermission("LibertyCity.staff.alerts");
                            p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit au silence le chat.");
                        }
                        Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat a été réduit au silence.");
                        return true;
                    }
                } else if(args.length == 1) {
                    String chatType = "";
                    for(int i = 1; i < args.length; i++) {
                        chatType += args[i] + " ";
                    }
                    String newStringConverted = "";
                    newStringConverted = chatType.replace("-s", "");
                    if(newStringConverted.equalsIgnoreCase("global") || newStringConverted.equalsIgnoreCase("police") || newStringConverted.equalsIgnoreCase("gang") || newStringConverted.equalsIgnoreCase("rp") || newStringConverted.equalsIgnoreCase("hrp")) {

                        if(newStringConverted.equalsIgnoreCase("global")) {
                            if (sData.chatStateGlobal) {
                                sData.chatStateGlobal = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8GLOBAL§7 au silence.");
                                }
                                Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat a été réduit au silence.");
                                return true;
                            } else {
                                sData.chatStateGlobal = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8GLOBAL§7 du silence.");
                                }
                                Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat a été déduit du silence.");
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("gang")) {
                            if (sData.chatStateGang) {
                                sData.chatStateGang = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8GANG§7 au silence.");
                                }
                                return true;
                            } else {
                                sData.chatStateGang = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if (p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8GANG§7 du silence.");
                                }
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("police")) {
                            if (sData.chatStatePolice) {
                                sData.chatStatePolice = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8POLICE§7 au silence.");
                                }
                                return true;
                            } else {
                                sData.chatStatePolice = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8POLICE§7 du silence.");
                                }
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("rp")) {
                            if (sData.chatStateRP) {
                                sData.chatStateRP = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8RP§7 au silence.");
                                }
                                return true;
                            } else {
                                sData.chatStateRP = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8RP§7 du silence.");
                                }
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("hrp")) {
                            if (sData.chatStateHRP) {
                                sData.chatStateHRP = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8HRP§7 au silence.");
                                }
                                return true;
                            } else {
                                sData.chatStateHRP = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8HRP§7 du silence.");
                                }
                                return true;
                            }
                        }

                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce chat n'existe pas !");
                } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments !");


            } else if(sender instanceof Player) sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission insufisante.");
        }
        return false;
    }*/
}
