package com.github.beastyboo.teamdeathmatch.domain;

import org.bukkit.Location;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Game {

    private final String name;
    private final Arena arena;
    private int length;
    private boolean running;
    private final Map<Team, Integer> scoreboard;
    private final Map<UUID, GamePlayer> players;

    private Game(String name, Arena arena, int length, boolean running, Map<Team, Integer> scoreboard, Map<UUID, GamePlayer> players) {
        this.name = name;
        this.arena = arena;
        this.length = length;
        this.running = running;
        this.scoreboard = scoreboard;
        this.players = players;
    }

    public static class Factory {
        public static Game createGame(String name, Arena arena, int length) {
            return new Game(name, arena, length, false, new HashMap<Team, Integer>(), new HashMap<UUID, GamePlayer>());
        }
    }

    public String getName() {
        return name;
    }

    public Arena getArena() {
        return arena;
    }

    public int getLength() {
        return length;
    }

    public boolean isRunning() {
        return running;
    }

    public Map<Team, Integer> getScoreboard() {
        return scoreboard;
    }

    public Map<UUID, GamePlayer> getPlayers() {
        return players;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return length == game.length && running == game.running && name.equals(game.name) && arena.equals(game.arena) && scoreboard.equals(game.scoreboard) && players.equals(game.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, arena, length, running, scoreboard, players);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", arena=" + arena +
                ", lenght=" + length +
                ", running=" + running +
                ", scoreboard=" + scoreboard +
                ", players=" + players +
                '}';
    }
}
