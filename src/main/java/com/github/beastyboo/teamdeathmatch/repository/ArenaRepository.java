package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Team;

import java.util.Set;

public interface ArenaRepository {

    void load();

    void close();

    boolean createArena(String name);

    boolean deleteArena(String name);

    boolean createSpawn(String name, String team);

    Arena getArena(String name);

    Set<Arena> getAllArenas();

}
