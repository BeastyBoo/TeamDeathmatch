package com.github.beastyboo.teamdeathmatch.application;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class TeamDeathMatchPlugin extends JavaPlugin {

    private TCore core;

    @Override
    public void onEnable() {
        core = new TCore(this);
        core.load();
    }

    @Override
    public void onDisable() {
        core.close();
        core = null;
    }

    public GameAPI getAPI() {
        if(core.getGameAPI() == null) {
            this.getLogger().log(Level.WARNING, "TeamDeathMatch has not loaded yet!!");
        }
        return core.getGameAPI();
    }

}
