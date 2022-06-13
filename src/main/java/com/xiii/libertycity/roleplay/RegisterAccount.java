package com.xiii.libertycity.roleplay;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.data.Data;
import com.xiii.libertycity.data.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RegisterAccount implements Listener {

    ArrayList<String> dbRPNom = new ArrayList<>();
    ArrayList<String> dbRPPrenom = new ArrayList<>();

    @EventHandler(priority = EventPriority.LOW)
    public void onMove(PlayerMoveEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            PlayerData data = Data.data.getUserData(e.getPlayer());

            if(!data.isVerified) {
                e.setCancelled(true);
            }

        });
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void forRegister(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            Data.data.registerUserJoin(e.getPlayer());
            PlayerData data = Data.data.getUserData(e.getPlayer());

            // RP NAME SET
            if (data.playerID == -1) {
                for(int i = 0; i < 121; i++) {
                    data.joinDate = System.currentTimeMillis();

                    if (data.rpPrenom == null && data.rpNom == null) {
                        e.getPlayer().sendTitle("§§§l§k|||§r §fBienvenue sur §2§lLiberty§a§lCity §6§lV5 §f! §4§l§k|||", "§6§k§l||§r §7Commencer par écrire votre §ePrénom RP §6§k§l||", 1, 120, 0);
                    } else if (data.rpPrenom != null && data.rpNom == null) {
                        e.getPlayer().sendTitle("§4§l§k|||§r §fBonjour §f" + data.rpPrenom + "§f! §4§l§k|||", "§6§k§l||§r §7Continuez avec votre §eNom RP §6§k§l||", 1, 120, 0);
                    } else if (data.rpPrenom != null && data.rpNom != null && data.rpAge == -1) {
                        e.getPlayer().sendTitle("§4§l§k|||§r §fBonjour §f" + data.rpPrenom + "§f" + data.rpNom + "§f! §4§l§k|||", "§6§k§l||§r §7Finiser par entrer votre §eÂge RP §6§k§l||", 1, 120, 0);
                    } else if (data.rpPrenom != null && data.rpNom != null && data.rpAge > 0 && !data.isVerified) {
                        final List<String> kickMessage = Arrays.asList("§5§l§k|||§r §fBienvenue §f" + data.rpPrenom + "§f" + data.rpNom + "§f! §5§l§k|||", "§d§k§l||§r §7Amusez vous bien ! §d§k§l||§r", " ", "§7§oVous avez été engregistré, reconectez-vous !");
                        e.getPlayer().kickPlayer(String.valueOf(kickMessage));
                        data.rpPrenom = tempPrenom;
                        data.rpNom = tempName;
                        data.rpAge = tempAge;
                        if(data.globalID <= 0) data.globalID = 1;
                        data.playerID = data.globalID;
                        data.globalID++;
                        dbRPNom.add(tempName);
                        dbRPPrenom.add(data.rpPrenom);
                        data.isVerified = true;
                    }
                    while(data.tempvarjoin) {
                        if(data.timer.isDelayComplete(1000)) {
                            data.timer.reset();
                            data.tempvarjoin = false;
                        }
                    }
                }
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

    @EventHandler
    public void forChatRegister(AsyncPlayerChatEvent e) {
        Bukkit.getScheduler().runTaskAsynchronously(LibertyCity.instance, () -> {

            PlayerData data = Data.data.getUserData(e.getPlayer());
            List<String> optYes = Arrays.asList("yes", "oui", "o", "y");
            List<String> optNo = Arrays.asList("no", "non", "n", "annule", "cancel");
            //List<String> remCara = Arrays.asList(",", "?", ";", ".", ":", "/", "!", "^", "¨", "$", "£", "¤", "ù", "%", "*", "µ", ")", "=", "+", "}", "°", "]", "~", "'", "{", "(", "[", "-", "|", "`", "_", "@", "²", "&", "<", ">", "#");

            if(data.playerID == -1) {
                if(data.rpPrenom != null) {
                    if(data.rpNom != null) {
                        if(!data.confirmWait3) {
                            int message = Integer.parseInt(e.getMessage());
                            if(message >= 18 && message <= 80) {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fDonc vous avez §e" + message + " §fans ? §7(Oui/Non)");
                                tempAge = message;
                                data.confirmWait3 = true;
                            } else {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Votre âge RP doit être entre §e18§c et §e80§c ans.");
                            }
                        } else if(optYes.contains(e.getMessage())) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fOh, vous avez §e" + tempAge + " §f? Moi aussi !");
                        } else if(optNo.contains(e.getMessage())) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fAh! Veuillez re-écrire votre §eÂge RP");
                            data.confirmWait3 = false;
                        }
                    } else if(data.rpNom == null) {
                        if(!data.confirmWait2) {
                            tempName = e.getMessage();
                            tempName.replaceAll("nigger", "");
                            if(tempName.length() > 3 && tempName.length() < 18) {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous vous appelez bien §a" + data.rpPrenom + " §2" + tempName + " §f ?");
                                data.confirmWait2 = true;
                            } else {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Votre §eNom RP§c doit être entre 3 et 18 caractères !");
                                data.confirmWait1 = false;
                                data.confirmWait2 = false;
                            }
                        } else if(optYes.contains(e.getMessage())) {
                            if(dbRPNom.contains(tempName) && dbRPPrenom.contains(tempPrenom)) {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Ce Nom RP et Prénom RP sont déja en utilisiation.");
                                tempPrenom = null;
                                tempName = null;
                                data.confirmWait2 = false;
                                data.confirmWait1 = false;
                            } else {
                                e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fEnchanté de faire votre conaissance §a" + data.rpPrenom + " §2" + tempName + " §f!");
                            }
                        } else if(optNo.contains(e.getMessage())) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fAh! Veuillez re-écrire votre §ePrénom RP§f et §eNom RP");
                            data.confirmWait1 = false;
                            data.confirmWait2 = false;
                        }
                    }
                } else if(data.rpPrenom == null) {
                    if(!data.confirmWait1) {
                        tempPrenom = e.getMessage();
                        tempPrenom.replaceAll("nigger", "");
                        if(tempPrenom.length() < 3 || tempPrenom.length() > 18) {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cAttention! Votre §ePrénom RP§c doit être entre 3 et 18 caractères");
                            data.confirmWait1 = false;
                        } else {
                            e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fVous vous appelez bien §a" + tempPrenom + " §f?");
                            data.confirmWait1 = true;
                        }
                    } else if(optYes.contains(e.getMessage())) {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fParfait! Bien le bonjour §a" + tempPrenom + " §f!");
                    } else if(optNo.contains(e.getMessage())) {
                        e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §fAh! Veuillez re-écrire votre §ePrénom RP");
                        data.confirmWait1 = false;
                    }
                }
            } e.setCancelled(true);

        });
    }

}
