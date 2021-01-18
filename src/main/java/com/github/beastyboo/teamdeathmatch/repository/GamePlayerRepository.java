package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.Game;
import com.github.beastyboo.teamdeathmatch.domain.GamePlayer;
import com.github.beastyboo.teamdeathmatch.domain.Team;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

public interface GamePlayerRepository {

    boolean createGamePlayer(Game game, Team team, Player player);

    boolean deleteGamePlayer(Game game, Player player);

    GamePlayer getGamePlayer(UUID uuid);

    Set<GamePlayer> getAllGamePlayers();

}
