package com.xiii.libertycity;

import com.xiii.libertycity.core.Events;
import com.xiii.libertycity.core.command.ClearLag;
import com.xiii.libertycity.core.command.Kick;
import com.xiii.libertycity.roleplay.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LibertyCity extends JavaPlugin {

    public static LibertyCity instance;
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading...");
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading Commands...");
        Bukkit.getPluginCommand("clearlag").setExecutor(new ClearLag());
        Bukkit.getPluginCommand("kick").setExecutor(new Kick());
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading Events...");
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new AnkleBreak(), this);
        Bukkit.getPluginManager().registerEvents(new CustomChat(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new RegisterAccount(), this);
        Bukkit.getPluginManager().registerEvents(new SearchTool(), this);
        Bukkit.getConsoleSender().sendMessage("§7[§2§lLiberty§a§lCity§7] §aPlugin activé !");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eCanceling Tasks...");
        Bukkit.getScheduler().cancelTasks(this);
        Bukkit.getConsoleSender().sendMessage("§7[§2§lLiberty§a§lCity§7] §cPlugin désactivé !");
    }
}
