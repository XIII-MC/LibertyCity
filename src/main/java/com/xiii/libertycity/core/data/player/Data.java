package com.xiii.libertycity.core.data.player;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

public enum Data {
    data;

    public ArrayList<PlayerData> users = new ArrayList<>();


    public void registerUser(Player p) {
        if (!isAlreadyRegistered(p)) {
            PlayerData pd = new PlayerData(p.getName(), p.getUniqueId());
            this.users.add(pd);
        }
    }
    public void registerUserJoin(Player p) {
        if (!isAlreadyRegistered(p)) {
            PlayerData pd = new PlayerData(p.getName(), p.getUniqueId());
            this.users.add(pd);
        } else {
            this.users.remove(getUserData(p));
            PlayerData pd = new PlayerData(p.getName(), p.getUniqueId());
            this.users.add(pd);
        }
    }

    public boolean isAlreadyRegistered(Player p) {
        return getUserData(p) != null;
    }

    public ArrayList<PlayerData> getUsers() {
        return this.users;
    }

    public PlayerData getUserData(Player p) {
        for (PlayerData user : users) {
            if (user.uuid.toString().contains(p.getUniqueId().toString())) {

                return user;
            }
        }
        return null;
    }

}
