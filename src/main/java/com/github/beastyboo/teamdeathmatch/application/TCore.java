package com.github.beastyboo.teamdeathmatch.application;

import com.github.beastyboo.teamdeathmatch.entrypoint.GameAPI;
import org.bukkit.plugin.java.JavaPlugin;

public class TCore {

    private final JavaPlugin plugin;
    private GameAPI gameAPI;

    public TCore(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    void load() {
        gameAPI = new GameAPI(this);
    }

    void close() {

    }

    public GameAPI getGameAPI() {
        return gameAPI;
    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}
