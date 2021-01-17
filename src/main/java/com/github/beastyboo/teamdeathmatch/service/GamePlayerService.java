package com.github.beastyboo.teamdeathmatch.service;

import com.github.beastyboo.teamdeathmatch.application.TCore;
import com.github.beastyboo.teamdeathmatch.domain.GamePlayer;
import com.github.beastyboo.teamdeathmatch.repository.GamePlayerRepository;

import java.util.*;

public class GamePlayerService implements GamePlayerRepository {

    private final TCore plugin;
    private final Map<UUID, GamePlayer> gamePlayers;

    public GamePlayerService(TCore plugin) {
        this.plugin = plugin;
        gamePlayers = new HashMap<>();
    }

    @Override
    public void load() {

    }

    @Override
    public void close() {

    }

    @Override
    public boolean createGamePlayer(UUID uuid) {
        return false;
    }

    @Override
    public boolean deleteGamePlayer(UUID uuid) {
        return false;
    }

    @Override
    public GamePlayer getGamePlayer(UUID uuid) {
        return gamePlayers.get(uuid);
    }

    @Override
    public Set<GamePlayer> getAllGamePlayers() {
        return new HashSet<>(gamePlayers.values());
    }
}
