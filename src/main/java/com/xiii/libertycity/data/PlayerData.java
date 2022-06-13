package com.xiii.libertycity.data;

import com.xiii.libertycity.core.utils.Timer;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerData {

    // Server/Plugin Related
    public Timer timer = new Timer();
    public boolean tempvarjoin = true;

    // Main Player Useful Related
    public UUID uuid;
    public Player player;
    public String name;

    // Main Player Var Storage
    public int playerID = -1;
    public int globalID;
    public String rpPrenom;
    public String rpNom;
    public boolean confirmWait1 = false;
    public boolean confirmWait2 = false;
    public boolean confirmWait3 = false;
    public int rpAge = -1;
    public int rpBank = -1;
    public int rpCurrentChat = 0;
    public String rpCurrentJob = "§eCitoyen";
    public boolean isVerified;
    public long joinDate;

    public PlayerData(String name, UUID uuid) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer() {
        return player;
    }

}
