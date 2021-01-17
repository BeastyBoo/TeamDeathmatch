package com.github.beastyboo.teamdeathmatch.domain;

import java.util.Objects;
import java.util.UUID;

public class GamePlayer {

    private final UUID uuid;
    private final Team team;

    public GamePlayer(UUID uuid, Team team) {
        this.uuid = uuid;
        this.team = team;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Team getTeam() {
        return team;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GamePlayer that = (GamePlayer) o;
        return uuid.equals(that.uuid) && team == that.team;
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, team);
    }

    @Override
    public String toString() {
        return "GamePlayer{" +
                "uuid=" + uuid +
                ", team=" + team +
                '}';
    }
}
