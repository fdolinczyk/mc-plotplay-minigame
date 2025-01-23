package pl.warchamer12.minigame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import pl.warchamer12.minigame.Objects.GameObjects;
import pl.warchamer12.minigame.commands.JoinMinigameCommand;
import pl.warchamer12.minigame.commands.LobbyCommand;
import pl.warchamer12.minigame.commands.SetQueueCommand;
import pl.warchamer12.minigame.commands.SetSpawnPointsCommand;

import pl.warchamer12.minigame.config.configManager;

import pl.warchamer12.minigame.listeners.DeathListener;
import pl.warchamer12.minigame.listeners.LeaveListener;
import pl.warchamer12.minigame.listeners.SnowballListener;

public final class Minigame extends JavaPlugin {

    public static GameObjects objects;

    public configManager configM = configManager.getInstance();

    private static Minigame INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;

        this.saveDefaultConfig();

        configM.createFile(this);
        configM.saveConfiguration();

        this.registerCommands();

        objects = new GameObjects(this);

        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        getLogger().info("Enabling Snowball minigame");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling Snowball minigame");
    }

    private void registerCommands() {
        getCommand("setqueue").setExecutor(new SetQueueCommand());
        getCommand("leave").setExecutor(new LobbyCommand());
        getCommand("setspawnpoint").setExecutor(new SetSpawnPointsCommand());
        getCommand("join").setExecutor(new JoinMinigameCommand());
    }

    private void registerListeners() {
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new DeathListener(), this);
        pluginManager.registerEvents(new LeaveListener(), this);
        pluginManager.registerEvents(new SnowballListener(), this);
    }

    public static Plugin getInstance() {
        return INSTANCE;
    }
}
