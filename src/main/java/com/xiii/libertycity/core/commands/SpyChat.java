package com.xiii.libertycity.core.commands;

import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpyChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("spy")) {

            PlayerData data = Data.data.getUserData((Player) sender);

            if(args.length < 1) {
                sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! /spy <Chat/Msg> (HRP,RP,Police,Gang,All,*)");
                return true;

            } else if(args.length == 1) {
                if(args[0].equalsIgnoreCase("msg")) {
                    if(data.spyMsg) {
                        data.spyMsg = false;
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy MSG §c§ndésactivé");
                        return true;
                    } else {
                        data.spyMsg = true;
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy MSG §a§nactivé");
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("chat") && args.length < 2) {
                    sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Veuillez séléctionner un chat! (HRP, RP, Police, Gang, All/*)");
                    return true;
                }

            } else if(args.length >= 2) {
                if(args[0].equalsIgnoreCase("chat")) {

                    if (args[1].equalsIgnoreCase("rp") || args[1].equalsIgnoreCase("hrp") || args[1].equalsIgnoreCase("police") || args[1].equalsIgnoreCase("gang") || args[1].equalsIgnoreCase("all") || args[1].equalsIgnoreCase("*")) {

                        if(args[1].equalsIgnoreCase("rp")) {
                            if(data.spyChatRP) {
                                data.spyChatRP = false;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat RP §c§ndésactivé");
                                return true;
                            } else {
                                data.spyChatRP = true;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat RP §a§nactivé");
                                return true;
                            }
                        }

                        if(args[1].equalsIgnoreCase("hrp")) {
                            if(data.spyChatHRP) {
                                data.spyChatHRP = false;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat HRP §c§ndésactivé");
                                return true;
                            } else {
                                data.spyChatHRP = true;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat HRP §a§nactivé");
                                return true;
                            }
                        }

                        if(args[1].equalsIgnoreCase("police")) {
                            if(data.spyChatPolice) {
                                data.spyChatPolice = false;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat Police §c§ndésactivé");
                                return true;
                            } else {
                                data.spyChatPolice = true;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat Police §a§nactivé");
                                return true;
                            }
                        }

                        if(args[1].equalsIgnoreCase("gang")) {
                            if(data.spyChatGang) {
                                data.spyChatGang = false;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat Gang §c§ndésactivé");
                                return true;
                            } else {
                                data.spyChatGang = true;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat Gang §a§nactivé");
                                return true;
                            }
                        }

                        if(args[1].equalsIgnoreCase("all") || args[1].equalsIgnoreCase("*")) {
                            if(data.spyChatGlobal) {
                                data.spyChatGlobal = false;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat Global §c§ndésactivé");
                                return true;
                            } else {
                                data.spyChatGlobal = true;
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §fSpy chat Global §a§nactivé");
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }
}
