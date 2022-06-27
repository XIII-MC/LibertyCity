package com.xiii.libertycity.core.utils;

import com.xiii.libertycity.LibertyCity;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class FileUtility {

    File file = null;
    FileConfiguration configuration = null;
    OfflinePlayer player = null;

    public FileUtility(Player player) {

    }

    /**
     * @param player reference of data
     */
    public void FileUtility(OfflinePlayer player) {
        this.player = player;
    }

    /**
     * get the config from file
     * @return file configuration
     */
    public FileConfiguration getConfig() {
        if(configuration == null) {
            configuration = YamlConfiguration.loadConfiguration(getFile());
            return configuration;
        }
        return configuration;
    }

    /**
     * this will save the config to the file
     */
    public void saveConfig() {
        try {
            configuration.save(file);
            Bukkit.getConsoleSender().sendMessage("§aSaved change for " + file.getName());
        } catch (IOException e) {
            Bukkit.getConsoleSender().sendMessage("§cCannot save to " + file.getName());
        }
    }

    /**
     * set an object to a certain path
     * @param path the path
     * @param object the object to set
     */
    public void set(String path, Object object) {
        getConfig().set(player.getName() + "." + path, object);
        saveConfig();
    }

    /**
     * this will get the player's file
     * @return the player's uuid file
     */
    public File getFile() {
        if(file == null) {
            this.file = new File(LibertyCity.getInstance().getDataFolder() + "/players", player.getUniqueId().toString() + ".yml");
            if(!this.file.exists()) {
                try {
                    if(this.file.createNewFile()) {
                        Bukkit.getConsoleSender().sendMessage("§6File for §e" + player.getName() + " §6has been created");
                        Bukkit.getConsoleSender().sendMessage("§aSaved as §e" + player.getUniqueId().toString() + "§e.yml");
                    }
                }catch (IOException e) {
                    Bukkit.getConsoleSender().sendMessage("§cCannot create data for §4" + player.getName());
                }
            }
            return file;
        }
        return file;
    }

    /**
     * this will reload the config
     */
    public void reloadConfig() {
        YamlConfiguration.loadConfiguration(file);
    }

}
