package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Game;
import com.github.beastyboo.teamdeathmatch.domain.Team;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

public interface GameRepository {

    boolean createGame(Player player, String name, String arena);

    boolean deleteGame(Player player, String name);

    boolean startGame(Game game);

    boolean endGame(Game game);

    boolean addKill(UUID uuid);

    Team getTeam(Game game, UUID uuid);

    Game getGame(String name);

    Game getGame(UUID uuid);

    Set<Game> getAllGames();

    Set<Game> getAllActiveGames();

}
