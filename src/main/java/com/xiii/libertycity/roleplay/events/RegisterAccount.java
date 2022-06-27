package com.xiii.libertycity.roleplay.events;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.player.DB;
import com.xiii.libertycity.core.data.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterAccount implements Listener {

    ArrayList<String> dbRPNom = new ArrayList<>();
    ArrayList<String> dbRPPrenom = new ArrayList<>();

    @EventHandler(priority = EventPriority.LOWEST)
    public void onMove(PlayerMoveEvent e) {
        PlayerData data = DB.data.getUserData(e.getPlayer());
        if(data.playerID == -1) {
            e.getPlayer().sendMessage("slAYED");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void commandChecker(PlayerCommandPreprocessEvent e) {
        PlayerData data = DB.data.getUserData(e.getPlayer());

        //if(data.playerID == -1) e.setCancelled(true);

    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void forRegister(PlayerJoinEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {
            PlayerData data = DB.data.getUserData(e.getPlayer());

            e.getPlayer().sendTitle("§§§l§k|||§r §fBienvenue sur §2§lLiberty§a§lCity §6§lV5 §f! §4§l§k|||", "§6§k§l||§r §7Commencer par écrire votre §e§nPrénom RP§r §6§k§l||", 0, 14000, 0);
            if(data.playerID == -1) {
            } else {
                if(data.rpBank == -1) {
                    data.rpBank = 0;
                    Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §a" + data.rpPrenom + " §2" + data.rpNom + " §f rejoint la ville !");
                }
            }


        });
    }

    int tempAge;
    String tempName;
    String tempPrenom;

    boolean confirmWait1;
    boolean confirmWait2;
    boolean confirmWait3;

    @EventHandler(priority = EventPriority.HIGHEST)
    public void forChatRegister(AsyncPlayerChatEvent e) {
        PlayerData tdt = DB.data.getUserData(e.getPlayer());
        if(tdt.playerID == -1) e.setCancelled(true);
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            PlayerData data = DB.data.getUserData(e.getPlayer());
            List<String> optYes = Arrays.asList("yes", "oui", "o", "y", "Yes", "Oui", "O", "Y", "Yas", "yas", "ye", "Ye", "Ya", "ya");
            List<String> optNo = Arrays.asList("no", "non", "n", "annule", "cancel", "nah", "Non", "No", "N", "Nah");
            //List<String> remCara = Arrays.asList(",", "?", ";", ".", ":", "/", "!", "^", "¨", "$", "£", "¤", "ù", "%", "*", "µ", ")", "=", "+", "}", "°", "]", "~", "'", "{", "(", "[", "-", "|", "`", "_", "@", "²", "&", "<", ">", "#");

            if(data.playerID == -1) {
                if(data.rpPrenom != null) {
                    if(data.rpNom != null) {
                        if(!confirmWait3) {
                            int message = Integer.parseInt(e.getMessage());
                            if(message >= 18 && message <= 80) {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fDonc vous avez §e" + message + " §fans ? §7(Oui/Non)");
                                tempAge = message;
                                confirmWait3 = true;
                            } else {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Votre âge RP doit être entre §e18§c et §e80§c ans.");
                            }
                        } else if(optYes.contains(e.getMessage())) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fOh, vous avez §e" + tempAge + " §f? Moi aussi !");
                            data.rpAge = tempAge;
                            e.getPlayer().sendTitle("§4§l§k|||§r §fBonjour §a" + data.rpPrenom + " §2" + data.rpNom + "§f! §4§l§k|||", "§6§k§l||§r §7Nous finissons votre carte d'identité §6§k§l||", 0, 14000, 0);
                            String kickMessage = ("§5§l§k|||§r §fBienvenue §a" + data.rpPrenom + " §2" + data.rpNom + "§f! §5§l§k|||" + "\n" + "§d§k§l||§r §7Amusez vous bien ! §d§k§l||§r" + "\n" + " " + "\n" + "§7§oVous avez été engregistré, reconectez-vous !");
                            while(data.tempvarjoin) {
                                if(data.timerUtility.isDelayComplete(3000)) {
                                    data.timerUtility.reset();
                                    data.tempvarjoin = false;
                                }
                            }
                            e.getPlayer().kickPlayer(kickMessage);
                            data.rpPrenom = tempPrenom;
                            data.rpNom = tempName;
                            data.rpAge = tempAge;
                            if(data.globalID <= 0) data.globalID = 1;
                            data.playerID = data.globalID;
                            data.globalID++;
                            dbRPNom.add(tempName);
                            dbRPPrenom.add(data.rpPrenom);
                            data.isVerified = true;
                        } else if(optNo.contains(e.getMessage())) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fAh! Veuillez re-écrire votre §eÂge RP");
                            confirmWait3 = false;
                        }
                    } else if(data.rpNom == null) {
                        if(!confirmWait2) {
                            tempName = e.getMessage();
                            tempName.replaceAll("nigger", "");
                            if(tempName.length() > 3 && tempName.length() < 18) {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous vous appelez bien §a" + data.rpPrenom + " §2" + tempName + " §f ? §7(Oui/Non)");
                                confirmWait2 = true;
                            } else {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Votre §eNom RP§c doit être entre 3 et 18 caractères !");
                                confirmWait1 = false;
                                confirmWait2 = false;
                            }
                        } else if(optYes.contains(e.getMessage())) {
                            if(dbRPNom.contains(tempName) && dbRPPrenom.contains(tempPrenom)) {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce Nom RP et Prénom RP sont déja en utilisiation.");
                                tempPrenom = null;
                                tempName = null;
                                confirmWait2 = false;
                                confirmWait1 = false;
                            } else {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fEnchanté de faire votre conaissance §a" + data.rpPrenom + " §2" + tempName + " §f!");
                                data.rpNom = tempName;
                                e.getPlayer().sendTitle("§4§l§k|||§r §fBonjour §a" + data.rpPrenom + " §2" + data.rpNom + "§f! §4§l§k|||", "§6§k§l||§r §7Finiser par entrer votre §e§nÂge RP§r §6§k§l||", 0, 14000, 0);
                            }
                        } else if(optNo.contains(e.getMessage())) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fAh! Veuillez re-écrire votre §ePrénom RP§f et §eNom RP");
                            confirmWait1 = false;
                            confirmWait2 = false;
                        }
                    }
                } else if(data.rpPrenom == null) {
                    if(!confirmWait1) {
                        tempPrenom = e.getMessage();
                        tempPrenom.replaceAll("nigger", "");
                        if(tempPrenom.length() < 3 || tempPrenom.length() > 18) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Votre §ePrénom RP§c doit être entre 3 et 18 caractères");
                            confirmWait1 = false;
                        } else {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous vous appelez bien §a" + tempPrenom + " §f? §7(Oui/Non)");
                            confirmWait1 = true;
                        }
                    } else if(optYes.contains(e.getMessage())) {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fParfait! Bien le bonjour §a" + tempPrenom + " §f!");
                        data.rpPrenom = tempPrenom;
                        e.getPlayer().sendTitle("§4§l§k|||§r §fBonjour §a" + data.rpPrenom + " §2! §4§l§k|||", "§6§k§l||§r §7Continuez avec votre §e§nNom RP§r §6§k§l||", 0, 14000, 0);
                    } else if(optNo.contains(e.getMessage())) {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fAh! Veuillez re-écrire votre §ePrénom RP");
                        confirmWait1 = false;
                    }
                }
            }
        });
    }

}
