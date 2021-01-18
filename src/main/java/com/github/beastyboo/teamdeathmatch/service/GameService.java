package com.github.beastyboo.teamdeathmatch.service;

import com.github.beastyboo.teamdeathmatch.application.TCore;
import com.github.beastyboo.teamdeathmatch.domain.Arena;
import com.github.beastyboo.teamdeathmatch.domain.Game;
import com.github.beastyboo.teamdeathmatch.domain.GamePlayer;
import com.github.beastyboo.teamdeathmatch.domain.Team;
import com.github.beastyboo.teamdeathmatch.repository.GameRepository;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.*;

public class GameService implements GameRepository {

    private final TCore core;
    private final Map<String, Game> games;

    public GameService(TCore core) {
        this.core = core;
        games = new HashMap<>();
    }

    @Override
    public boolean createGame(Player player, String name, String arena) {

        if(this.getGame(name.toLowerCase()) != null) {
            player.sendMessage("Game with this name already exist");
            return false;
        }

        Arena arena1 = core.getGameAPI().getArena(arena);

        if(arena1 == null) {
            player.sendMessage("Can't find arena: "  + arena);
            return false;
        }

        games.put(name.toLowerCase(), Game.Factory.createGame(name, arena1, 600));
        player.sendMessage("Game successfully created!");

        return true;
    }

    @Override
    public boolean deleteGame(Player player, String name) {
        Game game = this.getGame(name);

        if(game == null) {
            player.sendMessage("Game don't exist");
            return false;
        }

        if(game.isRunning()) {
            player.sendMessage("Wait until game is finished!");
            return false;
        }

        games.remove(name.toLowerCase(), game);
        player.sendMessage("Game removed!");

        return true;
    }

    @Override
    public boolean startGame(Game game) {

        if(game.isRunning()) {
            return false;
        }

        List[] divided = this.split(Arrays.asList(Bukkit.getOnlinePlayers().toArray()));

        for(Object object : divided[0]) {
            if(object instanceof Player) {
                Player player = (Player) object;

                core.getGameAPI().createGamePlayer(game, Team.BLUE, player);
                player.teleport(game.getArena().getBlueSpawn());
            }
        }

        for(Object object : divided[1]) {
            if(object instanceof Player) {
                Player player = (Player) object;

                core.getGameAPI().createGamePlayer(game, Team.RED, player);
                player.teleport(game.getArena().getRedSpawn());
            }
        }

        game.setRunning(true);
        Bukkit.broadcastMessage(game.getName() + " HAS STARTED!!!");

        return true;
    }

    @Override
    public boolean endGame(Game game) {

        if(!game.isRunning()) {
            return false;
        }

        Set<Player> players = new HashSet<>();
        game.getPlayers().values().forEach(gamePlayer -> players.add(Bukkit.getPlayer(gamePlayer.getUuid())));
        players.forEach(player -> player.teleport(player.getWorld().getSpawnLocation()));
        players.forEach(player -> core.getGameAPI().deleteGamePlayer(game, player));


        int blue = game.getScoreboard().get(Team.BLUE);
        int red = game.getScoreboard().get(Team.RED);

        if(blue > red) {
            Bukkit.broadcastMessage("BLUE HAS WON!");
        } else if(red > blue) {
            Bukkit.broadcastMessage("RED HAS WON!");
        } else {
            Bukkit.broadcastMessage("IT'S A TIE!");
        }

        games.remove(game.getName().toLowerCase(), game);
        return true;
    }

    @Override
    public boolean addKill(UUID uuid) {
        Game game = this.getGame(uuid);

        if(game == null) {
            return false;
        }

        Team team = this.getTeam(game, uuid);

        if(team == null) {
            return false;
        }

        int i = game.getScoreboard().get(team);
        game.getScoreboard().put(team, i++);

        return true;
    }

    @Override
    public Team getTeam(Game game, UUID uuid) {
        for (GamePlayer gamePlayer : game.getPlayers().values()) {
            if(gamePlayer.getUuid().equals(uuid))
                return gamePlayer.getTeam();
        }
        return null;
    }

    @Override
    public Game getGame(String name) {
        return games.get(name.toLowerCase());
    }

    @Override
    public Game getGame(UUID uuid) {
        for(Game game : games.values()) {
            for(GamePlayer gamePlayer : game.getPlayers().values()) {
                if(gamePlayer.getUuid().equals(uuid))
                    return game;
            }
        }
        return null;
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

    private <T> List[] split(List<T> list) {
        int size = list.size();

        List<T> first = new ArrayList<>(list.subList(0, (size + 1)/2));
        List<T> second = new ArrayList<>(list.subList((size + 1)/2, size));

        return new List[] {first, second};
    }

}
