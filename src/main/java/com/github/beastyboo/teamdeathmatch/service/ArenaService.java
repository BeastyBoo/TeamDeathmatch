package com.github.beastyboo.teamdeathmatch.service;

import com.github.beastyboo.teamdeathmatch.application.GameCore;
import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.repository.ArenaRepository;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArenaService implements ArenaRepository {

    private final GameCore core;
    private final Map<String, Arena> arenas;

    public ArenaService(GameCore core) {
        this.core = core;
        arenas = new HashMap<>();
    }

    @Override
    public void load() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean createArena(Player player, String name) {
        if(this.getArena(name) != null) {
            player.sendMessage("Arena with that name already exist");
            return false;
        }

        Location defaultLoc = player.getWorld().getSpawnLocation();

        arenas.put(name.toLowerCase(), Arena.Factory.createArena(name, defaultLoc, defaultLoc));
        player.sendMessage("Arena created! add spawns to make it playable!");
        return true;
    }

    @Override
    public boolean deleteArena(Player player, String name) {
        Arena arena = this.getArena(name);

        if(arena == null) {
            player.sendMessage(name + " not found...");
            return false;
        }

        arenas.remove(name.toLowerCase(), arena);
        player.sendMessage(name + " removed!");
        return true;
    }

    @Override
    public boolean createSpawn(Player player, String name, String team) {
        Arena arena = this.getArena(name);

        if(arena == null) {
            player.sendMessage(name + " not found...");
            return false;
        }

        if(team.equalsIgnoreCase("blue")) {
            arena.setBlueSpawn(player.getLocation());
            player.sendMessage("blue spawn set!");
            return true;

        } else if(team.equalsIgnoreCase("red")) {
            arena.setRedSpawn(player.getLocation());
            player.sendMessage("red spawn set!");
            return true;

        } else {
            player.sendMessage("Available: §4Red or §bBlue");
            return false;
        }
    }

    @Override
    public Arena getArena(String name) {
        return arenas.get(name.toLowerCase());
    }

    @Override
    public Set<Arena> getAllArenas() {
        return new HashSet<>(arenas.values());
    }
}
