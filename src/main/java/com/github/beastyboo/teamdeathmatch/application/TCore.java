package com.github.beastyboo.teamdeathmatch.application;

import org.bukkit.plugin.java.JavaPlugin;

public class TCore {

    private final JavaPlugin plugin;

    public TCore(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    void load() {

    }

    void close() {

    }

    public JavaPlugin getPlugin() {
        return plugin;
    }
}
