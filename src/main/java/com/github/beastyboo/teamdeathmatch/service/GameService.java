package com.github.beastyboo.teamdeathmatch.service;

import com.github.beastyboo.teamdeathmatch.application.TCore;
import com.github.beastyboo.teamdeathmatch.domain.Game;
import com.github.beastyboo.teamdeathmatch.repository.GameRepository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameService implements GameRepository {

    private final TCore plugin;
    private final Map<String, Game> games;

    public GameService(TCore plugin) {
        this.plugin = plugin;
        games = new HashMap<>();
    }

    @Override
    public void load() {
        
    }

    @Override
    public void close() {

    }

    @Override
    public boolean createGame(String name, String arena) {
        return false;
    }

    @Override
    public boolean deleteGame(String name) {
        return false;
    }

    @Override
    public boolean startGame(String name) {
        return false;
    }

    @Override
    public boolean endGame(String name) {
        return false;
    }

    @Override
    public Game getGame(String name) {
        return games.get(name.toLowerCase());
    }

    @Override
    public Set<Game> getAllGames() {
        return new HashSet<>(games.values());
    }

    @Override
    public Set<Game> getAllActiveGames() {
        Set<Game> activeGames = new HashSet<>();
        for(Game game : games.values()) {
            if(game.isRunning())
                activeGames.add(game);
        }
        return activeGames;
    }
}
