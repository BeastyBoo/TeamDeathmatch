package com.github.beastyboo.teamdeathmatch.service;

import com.github.beastyboo.teamdeathmatch.application.TCore;
import com.github.beastyboo.teamdeathmatch.domain.Game;
import com.github.beastyboo.teamdeathmatch.domain.GamePlayer;
import com.github.beastyboo.teamdeathmatch.domain.Team;
import com.github.beastyboo.teamdeathmatch.repository.GamePlayerRepository;
import org.bukkit.entity.Player;

import java.util.*;

public class GamePlayerService implements GamePlayerRepository {

    private final TCore core;
    private final Map<UUID, GamePlayer> gamePlayers;

    public GamePlayerService(TCore core) {
        this.core = core;
        gamePlayers = new HashMap<>();
    }

    @Override
    public boolean createGamePlayer(Game game, Team team, Player player) {
        UUID uuid = player.getUniqueId();

        if(this.getGamePlayer(uuid) != null) {
            return false;
        }

        GamePlayer gamePlayer = GamePlayer.Factory.createGamePlayer(uuid, team);
        gamePlayers.put(uuid, gamePlayer);
        game.getPlayers().put(uuid, gamePlayer);
        player.sendMessage("You've been added to team " + team.toString());

        return true;
    }

    @Override
    public boolean deleteGamePlayer(Game game, Player player) {
        UUID uuid = player.getUniqueId();
        GamePlayer gamePlayer = this.getGamePlayer(player.getUniqueId());

        if(gamePlayer == null) {
            return false;
        }

        gamePlayers.remove(uuid, gamePlayer);
        game.getPlayers().remove(uuid, gamePlayer);
        player.sendMessage("You've been added to a game");

        return true;
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
