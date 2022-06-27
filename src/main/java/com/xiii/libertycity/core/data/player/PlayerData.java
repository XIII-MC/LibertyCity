package com.xiii.libertycity.core.data.player;

import com.xiii.libertycity.core.utils.TimerUtility;
import org.bukkit.entity.Player;

import java.util.UUID;

public class PlayerData {

    //Temp Stuff
    public TimerUtility timerUtility = new TimerUtility();
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
