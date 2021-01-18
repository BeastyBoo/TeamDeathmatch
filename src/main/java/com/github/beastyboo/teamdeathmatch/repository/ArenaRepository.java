package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Team;
import org.bukkit.entity.Player;

import java.util.Set;

public interface ArenaRepository {

    void load();

    void close();

    boolean createArena(Player player, String name);

    boolean deleteArena(Player player, String name);

    boolean createSpawn(Player player, String name, String team);

    Arena getArena(String name);

    Set<Arena> getAllArenas();

}
