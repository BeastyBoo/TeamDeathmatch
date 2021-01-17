package com.github.beastyboo.teamdeathmatch.domain;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Game {

    private final String name;
    private final Arena arena;
    private final int lenght;
    private final boolean running;
    private final Map<Team, Integer> scoreboard;
    private final Map<UUID, GamePlayer> players;

    public Game(String name, Arena arena, int lenght, boolean running, Map<Team, Integer> scoreboard, Map<UUID, GamePlayer> players) {
        this.name = name;
        this.arena = arena;
        this.lenght = lenght;
        this.running = running;
        this.scoreboard = scoreboard;
        this.players = players;
    }

    public String getName() {
        return name;
    }

    public Arena getArena() {
        return arena;
    }

    public int getLenght() {
        return lenght;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return lenght == game.lenght && running == game.running && name.equals(game.name) && arena.equals(game.arena) && scoreboard.equals(game.scoreboard) && players.equals(game.players);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, arena, lenght, running, scoreboard, players);
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", arena=" + arena +
                ", lenght=" + lenght +
                ", running=" + running +
                ", scoreboard=" + scoreboard +
                ", players=" + players +
                '}';
    }
}
