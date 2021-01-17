package com.github.beastyboo.teamdeathmatch.application;

import org.bukkit.plugin.java.JavaPlugin;

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
}
