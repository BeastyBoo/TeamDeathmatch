package com.github.beastyboo.teamdeathmatch.service;

import com.github.beastyboo.teamdeathmatch.application.TCore;
import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.repository.ArenaRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArenaService implements ArenaRepository {

    private final TCore plugin;
    private final Map<String, Arena> arenas;

    public ArenaService(TCore plugin) {
        this.plugin = plugin;
        arenas = new HashMap<>();
    }

    @Override
    public void load() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean createArena(String name) {
        return false;
    }

    @Override
    public boolean deleteArena(String name) {
        return false;
    }

    @Override
    public boolean createSpawn(String name, String team) {
        return false;
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
