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

        Player player = (Player) sender;

        if(command.getName().equalsIgnoreCase("gm") || command.getName().equalsIgnoreCase("gamemode")) {
            if(sender.hasPermission("LibertyCity.gamemode")) {

                if(args[0].equalsIgnoreCase("s") || args[0].equalsIgnoreCase("survie") || args[0].equalsIgnoreCase("survival")) {
                    if(sender.hasPermission("LibertyCity.gamemode.survival")) {
                        if(args.length == 1 ) {
                            player.setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                        } else if(args.length == 2) {
                            Player target = getServer().getPlayer(args[1]);
                            if(target.isOnline()) {
                                target.setGameMode(GameMode.SURVIVAL);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nsurvie");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                            }
                        }
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                }

                if(args[0].equalsIgnoreCase("c") || args[0].equalsIgnoreCase("creatif") || args[0].equalsIgnoreCase("creative")) {
                    if(sender.hasPermission("LibertyCity.gamemode.creative")) {
                        if(args.length == 1 ) {
                            player.setGameMode(GameMode.CREATIVE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                        } else if(args.length == 2) {
                            Player target = getServer().getPlayer(args[1]);
                            if(target.isOnline()) {
                                target.setGameMode(GameMode.CREATIVE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§ncréatif");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                            }
                        }
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                }

                if(args[0].equalsIgnoreCase("sp") || args[0].equalsIgnoreCase("spectateur") || args[0].equalsIgnoreCase("spectator")) {
                    if(sender.hasPermission("LibertyCity.gamemode.spectator")) {
                        if(args.length == 1 ) {
                            player.setGameMode(GameMode.SPECTATOR);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                        } else if(args.length == 2) {
                            Player target = getServer().getPlayer(args[1]);
                            if(target.isOnline()) {
                                target.setGameMode(GameMode.SPECTATOR);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nspectateur");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                            }
                        }
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                }

                if(args[0].equalsIgnoreCase("a") || args[0].equalsIgnoreCase("aventure") || args[0].equalsIgnoreCase("adventure")) {
                    if(sender.hasPermission("LibertyCity.gamemode.adventure")) {
                        if(args.length == 1 ) {
                            player.setGameMode(GameMode.ADVENTURE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                        } else if(args.length == 2) {
                            Player target = getServer().getPlayer(args[1]);
                            if(target.isOnline()) {
                                target.setGameMode(GameMode.ADVENTURE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§naventure");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                            }
                        }
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                }
            } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
        }

        return true;
    }

    public static class GMC implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gmc")) {
                if (sender.hasPermission("LibertyCity.gamemode.creative")) {
                    if (sender.hasPermission("LibertyCity.gamemode.creative")) {
                        if (args.length < 1) {
                            Player player = (Player) sender;
                            player.setGameMode(GameMode.CREATIVE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                        } else if (args.length == 1) {
                            Player target = Bukkit.getServer().getPlayer(args[0]);
                            if (target.isOnline()) {
                                target.setGameMode(GameMode.CREATIVE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§ncréatif");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§ncréatif");
                            }
                        } else if(args.length > 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
            }
            return true;
        }
    }

    public static class GMS implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gms")) {
                if (sender.hasPermission("LibertyCity.gamemode.survival")) {
                    if (sender.hasPermission("LibertyCity.gamemode.survival")) {
                        if (args.length < 1) {
                            Player player = (Player) sender;
                            player.setGameMode(GameMode.SURVIVAL);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                        } else if (args.length == 1) {
                            Player target = getServer().getPlayer(args[0]);
                            if (target.isOnline()) {
                                target.setGameMode(GameMode.SURVIVAL);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nsurvie");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nsurvie");
                            }
                        } else if(args.length > 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
            }
            return true;
        }
    }

    public static class GMA implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gma")) {
                if (sender.hasPermission("LibertyCity.gamemode.adventure")) {
                    if (sender.hasPermission("LibertyCity.gamemode.adventure")) {
                        if (args.length < 1) {
                            Player player = (Player) sender;
                            player.setGameMode(GameMode.ADVENTURE);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                        } else if (args.length == 1) {
                            Player target = Bukkit.getServer().getPlayer(args[0]);
                            if (target.isOnline()) {
                                target.setGameMode(GameMode.ADVENTURE);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§naventure");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§naventure");
                            }
                        } else if(args.length > 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
            }
            return true;
        }
    }

    public static class GMSP implements CommandExecutor {

        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

            if (command.getName().equalsIgnoreCase("gmsp")) {
                if (sender.hasPermission("LibertyCity.gamemode.spectator")) {
                    if (sender.hasPermission("LibertyCity.gamemode.spectator")) {
                        if (args.length < 1) {
                            Player player = (Player) sender;
                            player.setGameMode(GameMode.SPECTATOR);
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                        } else if (args.length == 1) {
                            Player target = Bukkit.getServer().getPlayer(args[0]);
                            if (target.isOnline()) {
                                target.setGameMode(GameMode.SPECTATOR);
                                sender.sendMessage("§2§lLiberty§a§lCity §7» §6" + target.getName() + "êtes désormais en §e§nspectateur");
                                target.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais en §e§nspectateur");
                            }
                        } else if(args.length > 1) sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
                    } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
                } else sender.sendMessage("§2§lLiberty§a§lCity §7» §cPermission Insuffisante.");
            }
            return true;
        }
    }
}
