package com.xiii.libertycity.roleplay.items;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.player.DB;
import com.xiii.libertycity.core.data.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;

public class SearchTool implements Listener {

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEntityEvent e){
        Bukkit.getScheduler().scheduleSyncDelayedTask(LibertyCity.instance, () -> {

            DB.data.registerUserJoin(e.getPlayer());
            PlayerData data = DB.data.getUserData(e.getPlayer());

            if(data.rpCurrentJob == "§bPolicier") {

                Entity target = e.getRightClicked();
                Player player = e.getPlayer();

                if (target.getType().equals(EntityType.PLAYER) && player.getInventory().getItemInMainHand().getTypeId() == 7428) {
                    HumanEntity targetPlayer = (HumanEntity) target;
                    Inventory targetInventory = targetPlayer.getInventory();

                    player.sendMessage("§2§lLiberty§a§lCity §7» §fVous fouillé §e" + targetPlayer);
                    target.sendMessage("§2§lLiberty§a§lCity §7» §fVous vous faites fouillé par §e" + player);
                    player.openInventory(targetInventory);
                }

            } else e.getPlayer().sendMessage("§2§lLiberty§a§lCity §7» §cErreur! Vous n'êtes pas de la Police !");
        });
    }

}
