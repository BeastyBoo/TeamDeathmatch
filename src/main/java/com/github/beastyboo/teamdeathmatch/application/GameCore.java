package com.github.beastyboo.teamdeathmatch.application;

import org.bukkit.plugin.java.JavaPlugin;

public class GameCore {

    private final JavaPlugin plugin;
    private GameAPI gameAPI;

    public GameCore(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    void load() {
        gameAPI = new GameAPI(this);

        //Service logics.
        gameAPI.initializeService();
        gameAPI.start();
    }

    void close() {
        gameAPI.close();
    }

    public GameAPI getGameAPI() {
        return gameAPI;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}
