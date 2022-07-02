package com.xiii.libertycity.roleplay.events;

import com.xiii.libertycity.LibertyCity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEvent implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            Player victim = e.getEntity();
            Player killer = e.getEntity().getKiller();

            if(victim != null) {
                if(killer != null) {
                    if (e.getDeathMessage().contains("fait tuer par")) e.setDeathMessage("§4☠ §c" + victim + " §7a été tué au corp à corp par §c" + killer);
                    if (e.getDeathMessage().contains("fait tirer dessus par")) e.setDeathMessage("§4⚠ §c" + victim + " §7s'est fait tirer dessus par §c" + killer);
                } else {
                    if (e.getDeathMessage().contains("notre monde")) e.setDeathMessage("§4☠ §c" + victim + " §7est mort.");
                    if (e.getDeathMessage().contains("fait tirer dessus par")) e.setDeathMessage("§4⚠ §c" + victim + " §7s'est fait tirer dessus.");
                    if (e.getDeathMessage().contains("fait tuer par")) e.setDeathMessage("§4☠ §c" + victim + " §7 a été tué par §c" + killer);
                }
                if (victim == killer) e.setDeathMessage("§4☠ §c" + victim + " §7c'est humilié.");
            }
        });
    }

}
