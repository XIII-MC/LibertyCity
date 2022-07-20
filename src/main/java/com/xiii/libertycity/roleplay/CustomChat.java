package com.xiii.libertycity.roleplay;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import com.xiii.libertycity.core.data.ServerData;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class CustomChat implements Listener, CommandExecutor {

    @EventHandler(priority = EventPriority.HIGH)
    public void onChat(AsyncPlayerChatEvent e) {
        PlayerData d = Data.data.getUserData(e.getPlayer());
        if(d.playerID <= 0) return;
        e.setCancelled(true);
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            PlayerData data = Data.data.getUserData(e.getPlayer());
            ServerData server = Data.data.getServerData(Bukkit.getServer());

            if(data.isMuted) {
                if(data.muteDuration <= 0) {
                    if(data.muteReason != null) {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée §cindéterminé§f le §c" + data.muteTime + "§f, raison, §c" + data.muteReason);
                        return;
                    } else {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous avez été rendu muet pour une durée §cindéterminé§f le §c" + data.muteTime);
                        return;
                    }
                } else {
                    if(data.muteCalc - System.currentTimeMillis() >= data.muteDuration) {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous avez retrouver la parole.");
                        data.isMuted = false;
                    } else {
                        if(data.muteReason != null) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes encore muet pour §c" + data.muteLeft + "§f, raison, §c" + data.muteReason);
                            return;
                        } else {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes encore muet pour §c" + data.muteLeft);
                            return;
                        }
                    }
                }
            }

            if(System.currentTimeMillis() - data.lastChat >= server.chatCooldownGlobal) {
                if (data.rpCurrentChat == 0) {
                    if (!data.chatBanHRP && !data.chatBanGlobal) {
                        if (server.chatStateGlobal || server.chatStateHRP) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                PlayerData temp = Data.data.getUserData(p);
                                if (temp.rpCurrentChat == 0)
                                    p.sendMessage("§7(§3§LHRP§7) §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §8| §e" + p.getName() + " §7» §f" + e.getMessage());
                                if (temp.spyChatHRP || temp.spyChatGlobal)
                                    p.sendMessage("§C§L[CS] §7(§3§LHRP§7) §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §8| §e" + p.getName() + " §7» §f" + e.getMessage());
                            }
                        } else
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Le chat est réduit au silence");
                    } else e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous êtes banni du chat HRP");
                }

                if (data.rpCurrentChat == 1) {
                    if (!data.chatBanRP && !data.chatBanGlobal) {
                        if (server.chatStateGlobal || server.chatStateRP) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                PlayerData temp = Data.data.getUserData(p);
                                if (temp.rpCurrentChat == 1)
                                    p.sendMessage("§7(§2§LRP§7) §f" + temp.rpCurrentJob + " §8| §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §7» §f" + e.getMessage());
                                if (temp.spyChatRP || temp.spyChatGlobal)
                                    p.sendMessage("§C§L[CS] §7(§2§LRP§7) §f" + temp.rpCurrentJob + " §8| §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §7» §f" + e.getMessage());
                            }
                        } else
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Le chat est réduit au silence");
                    } else e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous êtes banni du chat RP");
                }

                if (data.rpCurrentChat == 3) {
                    if (!data.chatBanGang && !data.chatBanGlobal) {
                        if (server.chatStateGlobal || server.chatStateGang) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                PlayerData temp = Data.data.getUserData(p);
                                if (temp.rpCurrentChat == 3)
                                    p.sendMessage("§7(§4§LGang§7) §f" + temp.rpGangRank + " §8| §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §7» §f" + e.getMessage());
                                if (temp.spyChatGang || temp.spyChatGlobal)
                                    p.sendMessage("§C§L[CS] §7(§4§LGang§7) §f" + temp.rpGangRank + " §8| §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §7» §f" + e.getMessage());
                            }
                        } else
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Le chat est réduit au silence");
                    } else e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous êtes banni du chat Gang");
                }

                if (data.rpCurrentChat == 2) {
                    if (!data.chatBanPolice && !data.chatBanGlobal) {
                        if (server.chatStateGlobal || server.chatStatePolice) {
                            for (Player p : Bukkit.getOnlinePlayers()) {
                                PlayerData temp = Data.data.getUserData(p);
                                if (temp.rpCurrentChat == 2)
                                    p.sendMessage("§7(§b§LPolice§7) §f" + temp.rpPoliceRank + " §8| §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §7» §f" + e.getMessage());
                                if (temp.spyChatPolice || temp.spyChatGlobal)
                                    p.sendMessage("§C§L[CS] §7(§b§LPolice§7) §f" + temp.rpPoliceRank + " §8| §A§L" + temp.rpPrenom + " §2§L" + temp.rpNom + " §7» §f" + e.getMessage());
                            }
                        } else
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Le chat est réduit au silence");
                    } else
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous êtes banni du chat Police");
                }
            }

            data.lastChat = System.currentTimeMillis();

        });
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(command.getName().equalsIgnoreCase("chat")) {
            if(args.length <= 0) {
                sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Veuillez selectionner un chat ! §7(HRP/RP/POLICE/GANG)");
                return true;
            } else if(args.length == 1) {

                PlayerData data = Data.data.getUserData((Player) sender);

                if(args[0].equalsIgnoreCase("hrp")) {
                    if(data.rpCurrentChat == 0) {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous êtes déja sur le chat HRP");
                        return true;
                    } else {
                        data.rpCurrentChat = 0;
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais sur le chat §6HRP");
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("rp")) {
                    if(data.rpCurrentChat == 1) {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous êtes déja sur le chat RP");
                        return true;
                    } else {
                        data.rpCurrentChat = 1;
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais sur le chat §6RP");
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("police")) {
                    if(data.rpCurrentJob == "§bPolice") {
                        if (data.rpCurrentChat == 2) {
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous êtes déja sur le chat Police");
                            return true;
                        } else {
                            data.rpCurrentChat = 2;
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais sur le chat §6Police");
                            return true;
                        }
                    } else {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous n'êtes pas de la Police");
                        return true;
                    }
                } else if(args[0].equalsIgnoreCase("gang")) {
                    if(data.rpCurrentJob == "§4Gang") {
                        if (data.rpCurrentChat == 3) {
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Vous êtes déja sur le chat Gang");
                            return true;
                        } else {
                            data.rpCurrentChat = 3;
                            sender.sendMessage("§2§lLiberty§a§lCity §7» §fVous êtes désormais sur le chat §6Gang");
                            return true;
                        }
                    } else {
                        sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous ne faites pas partis d'un Gang");
                        return true;
                    }
                }
            } else if(args.length > 1) {
                sender.sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Trop d'arguments");
                return true;
            }
        }

        return false;
    }
}
