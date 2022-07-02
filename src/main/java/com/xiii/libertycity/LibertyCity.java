package com.xiii.libertycity;

import com.xiii.libertycity.core.Events;
import com.xiii.libertycity.core.commands.*;
import com.xiii.libertycity.core.data.Data;
import com.xiii.libertycity.core.data.PlayerData;
import com.xiii.libertycity.core.utils.FileUtil;
import com.xiii.libertycity.roleplay.CustomChat;
import com.xiii.libertycity.roleplay.events.AnkleEvent;
import com.xiii.libertycity.roleplay.events.DeathEvent;
import com.xiii.libertycity.roleplay.events.RegisterEvent;
import com.xiii.libertycity.roleplay.guis.ATMGUI;
import com.xiii.libertycity.roleplay.guis.BinGUI;
import com.xiii.libertycity.roleplay.items.SearchItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
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
        Bukkit.getPluginCommand("atm").setExecutor(new ATMGUI());
        Bukkit.getPluginCommand("chat").setExecutor(new CustomChat());
        Bukkit.getPluginCommand("report").setExecutor(new Report());
        Bukkit.getPluginCommand("spy").setExecutor(new SpyChat());
        Bukkit.getPluginCommand("unban").setExecutor(new Unban());
        Bukkit.getPluginCommand("gm").setExecutor(new Gamemode());
        Bukkit.getPluginCommand("gamemode").setExecutor(new Gamemode());
        Bukkit.getPluginCommand("gma").setExecutor(new Gamemode.GMA());
        Bukkit.getPluginCommand("gms").setExecutor(new Gamemode.GMS());
        Bukkit.getPluginCommand("gmc").setExecutor(new Gamemode.GMC());
        Bukkit.getPluginCommand("gmsp").setExecutor(new Gamemode.GMSP());
        Bukkit.getPluginCommand("clear").setExecutor(new ClearInv());
        Bukkit.getPluginCommand("ci").setExecutor(new ClearInv());
        Bukkit.getPluginCommand("feed").setExecutor(new Feed());
        Bukkit.getPluginCommand("heal").setExecutor(new Heal());
        Bukkit.getPluginCommand("fly").setExecutor(new Fly());
        Bukkit.getPluginCommand("spy").setExecutor(new SpyChat());
        Bukkit.getPluginCommand("tp").setExecutor(new Teleport());
        Bukkit.getPluginCommand("teleport").setExecutor(new Teleport());
        Bukkit.getPluginCommand("unban").setExecutor(new Unban());
        Bukkit.getPluginCommand("day").setExecutor(new TimeSet());
        Bukkit.getPluginCommand("night").setExecutor(new TimeSet());
        Bukkit.getPluginCommand("vanish").setExecutor(new Vanish());
        Bukkit.getPluginCommand("v").setExecutor(new Vanish());
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eLoading Events...");
        Bukkit.getPluginManager().registerEvents(new Events(), this);
        Bukkit.getPluginManager().registerEvents(new AnkleEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CustomChat(), this);
        Bukkit.getPluginManager().registerEvents(new DeathEvent(), this);
        Bukkit.getPluginManager().registerEvents(new RegisterEvent(), this);
        Bukkit.getPluginManager().registerEvents(new SearchItem(), this);
        Bukkit.getPluginManager().registerEvents(new ATMGUI(), this);
        Bukkit.getPluginManager().registerEvents(new BinGUI(), this);
        Bukkit.getPluginManager().registerEvents(new Vanish(), this);
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eReading YML DataBase (PDB)...");
        FileUtil.readPlayerDatas();
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eReading YML DataBase (SDB)...");
        FileUtil.readServerDatas();
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eRegistering Server towards ServerData...");
        Data.data.registerServer(Bukkit.getServer());
        Bukkit.getConsoleSender().sendMessage("§7[§2§lLiberty§a§lCity§7] §aPlugin activé !");

        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eAuto-Clearlag is now enabled (300s)...");
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §FLes éboueurs ramasseront tout les déchets dans §630 seconde§f!"),270*20, 270*20);

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> Bukkit.broadcastMessage("§2§lLiberty§a§lCity §7» §FLes éboueurs ramasseront tout les déchets dans §610 seconde§f!"),300*20, 300*20);

        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "clearlag"),310*20, 310*20);

        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eAuto-MoneyHelp is now enabled (600)...");
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            for(Player p : Bukkit.getOnlinePlayers()) {
                PlayerData data = Data.data.getUserData(p);
                data.rpBank += 10;
                p.sendMessage("§8§M+---------------------------------------+");
                p.sendMessage("§2§lLiberty§a§lCity §7» §fVous avez reçu §e10$ §7(Aide de l'Etat)");
                p.sendMessage("§8§M+---------------------------------------+");
            }
        },600*20, 600*20);

        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eAuto-Broadcast is now enabled (1800s)...");
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            Bukkit.broadcastMessage("§8§M+---------------------------------------+");
            Bukkit.broadcastMessage("§e                      §8[§a§lINFORMATION§8]§e                      ");
            Bukkit.broadcastMessage("§8» §fUne question, un problème ? Utiliser §e/helpop §f!");
            Bukkit.broadcastMessage("§8» §fUn FreeKill, joueur non RP ? Utiliser §e/report <Joueur> <Raison>");
            Bukkit.broadcastMessage("§8» §fNous recrutons du Staff !");
            Bukkit.broadcastMessage("§8§M+---------------------------------------+");
        },1800*20, 1800*20);

        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eAuto-YML DataBase (PDB) writing is now enabled (15s)...");
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> {
            for(Player p : Bukkit.getOnlinePlayers()) {
                FileUtil.savePlayerData(Data.data.getUserData(p));
            }
        },15*20, 15*20);

        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eAuto-YML DataBase (SDB) writing is now enabled (1s)...");
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () -> FileUtil.saveServerDatas(Data.data.getServerData(Bukkit.getServer())), 20, 20);
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eCanceling Tasks...");
        Bukkit.getScheduler().cancelTasks(this);
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eWriting YML DataBase (PDB)...");
        for(Player p : Bukkit.getOnlinePlayers()) {
            FileUtil.savePlayerData(Data.data.getUserData(p));
        }
        Bukkit.getConsoleSender().sendMessage("§7[§2§LLiberty§A§LCity§7] §eWriting YML DataBase (SDB)...");
        FileUtil.saveServerDatas(Data.data.getServerData(Bukkit.getServer()));
        Bukkit.getConsoleSender().sendMessage("§7[§2§lLiberty§a§lCity§7] §cPlugin désactivé !");
    }
}
