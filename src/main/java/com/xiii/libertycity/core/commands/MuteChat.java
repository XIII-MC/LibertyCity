package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import com.xiii.libertycity.core.data.ServerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MuteChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("mutechat")) {
            if(sender.hasPermission("LibertyCity.mutechat.use")) {
                ServerData server = Data.data.getServerData(Bukkit.getServer());

                if(args.length <= 0) {
                    if (server.chatStateGlobal) {
                        server.chatStateGlobal = false;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8GLOBAL§7 au silence.");
                        }
                        Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Global§f a été réduit au silence.");
                        return true;
                    } else {
                        server.chatStateGlobal = true;
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8GLOBAL§7 du silence.");
                        }
                        Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Global§f a été déduit du silence.");
                        return true;
                    }
                } else if(args.length == 1) {
                    String newStringConverted = args[0];
                    if(newStringConverted.equalsIgnoreCase("global") || newStringConverted.equalsIgnoreCase("police") || newStringConverted.equalsIgnoreCase("gang") || newStringConverted.equalsIgnoreCase("rp") || newStringConverted.equalsIgnoreCase("hrp")) {

                        if(newStringConverted.equalsIgnoreCase("global")) {
                            if (server.chatStateGlobal) {
                                server.chatStateGlobal = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8GLOBAL§7 au silence.");
                                }
                                Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Global§f a été réduit au silence.");
                                return true;
                            } else {
                                server.chatStateGlobal = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8GLOBAL§7 du silence.");
                                }
                                Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Global§f a été déduit du silence.");
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("gang")) {
                            if (server.chatStateGang) {
                                server.chatStateGang = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8GANG§7 au silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 2) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Gang§f a été réduit du silence.");
                                }
                                return true;
                            } else {
                                server.chatStateGang = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if (p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8GANG§7 du silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 2) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Gang§f a été déduit du silence.");
                                }
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("police")) {
                            if (server.chatStatePolice) {
                                server.chatStatePolice = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8POLICE§7 au silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 3) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Police§f a été réduit du silence.");
                                }
                                return true;
                            } else {
                                server.chatStatePolice = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8POLICE§7 du silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 3) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6Police§f a été déduit du silence.");
                                }
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("rp")) {
                            if (server.chatStateRP) {
                                server.chatStateRP = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8RP§7 au silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 1) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6RP§f a été réduit du silence.");
                                }
                                return true;
                            } else {
                                server.chatStateRP = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8RP§7 du silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 1) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6RP§f a été déduit du silence.");
                                }
                                return true;
                            }
                        }

                        if(newStringConverted.equalsIgnoreCase("hrp")) {
                            if (server.chatStateHRP) {
                                server.chatStateHRP = false;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a réduit le chat §8HRP§7 au silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 0) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6HRP§f a été réduit du silence.");
                                }
                                return true;
                            } else {
                                server.chatStateHRP = true;
                                for (Player p : Bukkit.getOnlinePlayers()) {
                                    if(p.hasPermission("LibertyCity.staff.alerts")) p.sendMessage("§4§LSTAFF §7» §8" + sender.getName() + " §7a déduit le chat §8HRP§7 du silence.");
                                }
                                for(Player p : Bukkit.getOnlinePlayers()) {
                                    PlayerData data = Data.data.getUserData(p);
                                    if(data.rpCurrentChat == 0) p.sendMessage("§2§lLiberty§a§lCity §7» §fLe chat §6HRP§f a été déduit du silence.");
                                }
                                return true;
                            }
                        }

                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce chat n'existe pas !");
                } else if(args.length > 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments !");


            } else if(sender instanceof Player) sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission insufisante.");
        }
    return false;
    }
}
