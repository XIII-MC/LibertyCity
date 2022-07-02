package com.xiii.libertycity.core.commands;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class Gamemode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("gm") || command.getName().equalsIgnoreCase("gamemode")) {
            if(sender.hasPermission("LibertyCity.gamemode")) {
                Player target = getServer().getPlayer(args[1]);

                if(args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survie") || args[0].equalsIgnoreCase("survival")) {
                    if(sender.hasPermission("LibertyCity.gamemode.survival")) {
                        if(args.length == 1 ) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                        } else if(args.length == 2) {
                            if(target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.SURVIVAL);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nsurvie");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                            }
                        }
                    }
                }

                if(args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creatif") || args[0].equalsIgnoreCase("creative")) {
                    if(sender.hasPermission("LibertyCity.gamemode.creative")) {
                        if(args.length == 1 ) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.CREATIVE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                        } else if(args.length == 2) {
                            if(target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.CREATIVE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§ncréatif");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                            }
                        }
                    }
                }

                if(args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectateur") || args[0].equalsIgnoreCase("spectator")) {
                    if(sender.hasPermission("LibertyCity.gamemode.spectator")) {
                        if(args.length == 1 ) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.SPECTATOR);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                        } else if(args.length == 2) {
                            if(target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.SPECTATOR);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nspectateur");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                            }
                        }
                    }
                }

                if(args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("aventure") || args[0].equalsIgnoreCase("adventure")) {
                    if(sender.hasPermission("LibertyCity.gamemode.adventure")) {
                        if(args.length == 1 ) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.ADVENTURE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                        } else if(args.length == 2) {
                            if(target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.ADVENTURE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§naventure");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static class GMC implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gmc")) {
                if (sender.hasPermission("LibertyCity.gamemode.creative")) {
                    Player target = getServer().getPlayer(args[1]);
                    if (sender.hasPermission("LibertyCity.gamemode.creative")) {
                        if (args.length == 1) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.CREATIVE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                        } else if (args.length == 2) {
                            if (target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.CREATIVE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§ncréatif");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static class GMS implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gms")) {
                if (sender.hasPermission("LibertyCity.gamemode.survival")) {
                    Player target = getServer().getPlayer(args[1]);
                    if (sender.hasPermission("LibertyCity.gamemode.survival")) {
                        if (args.length == 1) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                        } else if (args.length == 2) {
                            if (target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.SURVIVAL);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nsurvie");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static class GMA implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gma")) {
                if (sender.hasPermission("LibertyCity.gamemode.adventure")) {
                    Player target = getServer().getPlayer(args[1]);
                    if (sender.hasPermission("LibertyCity.gamemode.adventure")) {
                        if (args.length == 1) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.ADVENTURE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                        } else if (args.length == 2) {
                            if (target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.ADVENTURE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§naventure");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

    public static class GMSP implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gmsp")) {
                if (sender.hasPermission("LibertyCity.gamemode.spectator")) {
                    Player target = getServer().getPlayer(args[1]);
                    if (sender.hasPermission("LibertyCity.gamemode.spectator")) {
                        if (args.length == 1) {
                            Bukkit.getPlayer(String.valueOf(sender)).setGameMode(GameMode.SPECTATOR);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                        } else if (args.length == 2) {
                            if (target.isOnline()) {
                                Bukkit.getPlayer(String.valueOf(target)).setGameMode(GameMode.SPECTATOR);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nspectateur");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
