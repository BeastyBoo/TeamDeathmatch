package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Game;
import org.bukkit.entity.Player;

import java.util.Set;

public interface GameRepository {

    boolean createGame(Player player, String name, String arena);

    boolean deleteGame(Player player, String name);

    boolean startGame(Game game);

    boolean endGame(Game game);

    Game getGame(String name);

    Set<Game> getAllGames();

    Set<Game> getAllActiveGames();

}
