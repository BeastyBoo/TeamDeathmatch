package com.github.beastyboo.teamdeathmatch.application;

import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Game;
import com.github.beastyboo.teamdeathmatch.domain.GamePlayer;
import com.github.beastyboo.teamdeathmatch.domain.Team;
import com.github.beastyboo.teamdeathmatch.repository.ArenaRepository;
import com.github.beastyboo.teamdeathmatch.repository.GamePlayerRepository;
import com.github.beastyboo.teamdeathmatch.repository.GameRepository;
import com.github.beastyboo.teamdeathmatch.service.ArenaService;
import com.github.beastyboo.teamdeathmatch.service.GamePlayerService;
import com.github.beastyboo.teamdeathmatch.service.GameService;
import org.bukkit.entity.Player;

import java.util.Set;
import java.util.UUID;

public class GameAPI {

    private final GameCore core;
    private ArenaRepository arena;
    private GamePlayerRepository gamePlayer;
    private GameRepository game;

    public GameAPI(GameCore core) {
        this.core = core;

    }

    protected void initializeService() {
        arena = new ArenaService(core);
        gamePlayer = new GamePlayerService(core);
        game = new GameService(core);
    }

    protected void start() {
        arena.load();
    }

    protected void close() {
        arena.close();
    }


    public boolean createArena(Player player, String name) {
        return arena.createArena(player, name);
    }

    public boolean deleteArena(Player player, String name) {
        return arena.deleteArena(player, name);
    }

    public boolean createSpawn(Player player, String name, String team) {
        return arena.createSpawn(player, name, team);
    }

    public Arena getArena(String name) {
        return arena.getArena(name);
    }

    public Set<Arena> getAllArenas() {
        return arena.getAllArenas();
    }

    public boolean createGamePlayer(Game game, Team team, Player player) {
        return gamePlayer.createGamePlayer(game, team, player);
    }

    public boolean deleteGamePlayer(Game game, Player player) {
        return gamePlayer.deleteGamePlayer(game, player);
    }

    public GamePlayer getGamePlayer(UUID uuid) {
        return gamePlayer.getGamePlayer(uuid);
    }

    public Set<GamePlayer> getAllGamePlayers() {
        return gamePlayer.getAllGamePlayers();
    }

}
