package com.xiii.libertycity.core.utils;

import com.xiii.libertycity.LibertyCity;
import com.xiii.libertycity.core.data.player.Data;
import com.xiii.libertycity.core.data.player.PlayerData;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.Objects;

public class FileUtility {

    public static void savePlayerData(PlayerData data) {
        try {
            if (!LibertyCity.instance.getDataFolder().exists())
                LibertyCity.instance.getDataFolder().mkdir();
            File filefolder = new File(LibertyCity.instance.getDataFolder() + "\\players\\");
            if (!filefolder.exists()) filefolder.mkdir();
            File file = new File(LibertyCity.instance.getDataFolder() + "\\players\\", data.getUuid() + ".libertycity");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileOutputStream fileOut = new FileOutputStream(LibertyCity.instance.getDataFolder() + "\\players\\" + data.getUuid() + ".libertycity");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void readPlayerDatas() {
        File configsfolder = new File(LibertyCity.instance.getDataFolder() + "\\players\\");

        if (configsfolder.listFiles() == null || Objects.requireNonNull(configsfolder.listFiles()).length < 1) {
            System.out.println("No PlayerData found");
            return;
        } else {
            for (final File file : Objects.requireNonNull(configsfolder.listFiles())) {
                try {
                    FileInputStream fileIn = new FileInputStream(file.getPath());
                    ObjectInputStream in = new ObjectInputStream(fileIn);
                    Data.data.users.add((PlayerData) in.readObject());
                    in.close();
                    fileIn.close();
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                } catch (ClassNotFoundException c) {
                    System.out.println("PlayerData class not found");
                    c.printStackTrace();
                    return;
                }
            }
        }
    }
}