package com.github.beastyboo.teamdeathmatch.repository;

import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Game;

import java.util.Set;

public interface GameRepository {

    void load();

    void close();

    boolean createGame(String name, String arena);

    boolean deleteGame(String name);

    boolean startGame(String name);

    boolean endGame(String name);

    Game getGame(String name);

    Set<Game> getAllGames();

    Set<Game> getAllActiveGames();

}
