package com.xiii.libertycity;

import com.xiii.libertycity.core.CustomChat;
import com.xiii.libertycity.core.Events;
import com.xiii.libertycity.core.commands.*;
import com.xiii.libertycity.roleplay.events.AnkleBreak;
import com.xiii.libertycity.roleplay.events.Death;
import com.xiii.libertycity.roleplay.events.RegisterAccount;
import com.xiii.libertycity.roleplay.guis.ATM;
import com.xiii.libertycity.roleplay.guis.Bin;
import com.xiii.libertycity.roleplay.items.SearchTool;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class LibertyCity extends JavaPlugin {

    public static LibertyCity instance;

    public static Plugin getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading...");
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading Commands...");
        Bukkit.getPluginCommand("clearlag").setExecutor(new ClearLag());
        Bukkit.getPluginCommand("kick").setExecutor(new Kick());
        Bukkit.getPluginCommand("ping").setExecutor(new Ping());
        Bukkit.getPluginCommand("mutechat").setExecutor(new MuteChat());
        Bukkit.getPluginCommand("cooldownchat").setExecutor(new CooldownChat());
        Bukkit.getPluginCommand("clearchat").setExecutor(new ClearChat());
        Bukkit.getPluginCommand("atm").setExecutor(new ATM());
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading Events...");
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new AnkleBreak(), this);
        Bukkit.getPluginManager().registerEvents(new CustomChat(), this);
        Bukkit.getPluginManager().registerEvents(new Death(), this);
        Bukkit.getPluginManager().registerEvents(new RegisterAccount(), this);
        Bukkit.getPluginManager().registerEvents(new SearchTool(), this);
        Bukkit.getPluginManager().registerEvents(new ATM(), this);
        Bukkit.getPluginManager().registerEvents(new Bin(), this);
        Bukkit.getPluginManager().registerEvents(new com.xiii.libertycity.test.events.Events(), this);
        Bukkit.getConsoleSender().sendMessage("§7[§2§lLiberty§a§lCity§7] §aPlugin activé !");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eCanceling Tasks...");
        Bukkit.getScheduler().cancelTasks(this);
        Bukkit.getConsoleSender().sendMessage("§7[§2§lLiberty§a§lCity§7] §cPlugin désactivé !");
    }
}
