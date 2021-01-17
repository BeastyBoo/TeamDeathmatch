package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.GamePlayer;

import java.util.Set;
import java.util.UUID;

public interface GamePlayerRepository {

    void load();

    void close();

    boolean createGamePlayer(UUID uuid);

    boolean deleteGamePlayer(UUID uuid);

    GamePlayer getGamePlayer(UUID uuid);

    Set<GamePlayer> getAllGamePlayers();

}
