package com.xiii.libertycity.roleplay;

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

            if(victim instanceof Player) {
                if(killer instanceof Player) {
                    if(victim != killer) {
                        if(e.getDeathMessage().contains("kill")) e.setDeathMessage("§4☠ §c" + victim + " §7a été tué au corp à corp par §c" + killer);
                        if(e.getDeathMessage().contains("shot")) e.setDeathMessage("§4⚠ §c" + victim + " §7c'est fait tirer dessus par §c" + killer);
                    } else e.setDeathMessage("§4☠ §c" + victim + " §7c'est humilié.");
                } else e.setDeathMessage("§4☠ §c" + victim + " §7 a été tué par §c" + killer);
            } else e.setDeathMessage("§4☠ §c" + victim + " §7est mort.");

        });
    }

}
