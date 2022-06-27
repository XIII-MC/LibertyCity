package com.xiii.libertycity.test.events;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.utils.FileUtility;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.io.File;
import java.io.IOException;

public class Events implements Listener {

    File file = null;

    @EventHandler
    public void test_onJoin(PlayerJoinEvent e) throws IOException {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        config.set("/players", e.getPlayer().getName());
        config.save(String.valueOf(e.getPlayer().getUniqueId()));

        e.getPlayer().sendMessage("Name should be saved. (CONSOLE RETURNED)");

    }

}
