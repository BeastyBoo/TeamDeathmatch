package com.github.beastyboo.teamdeathmatch.domain;

import org.bukkit.Location;

import java.util.Objects;

public class Arena {

    private final String name;
    private Location blueSpawn;
    private Location redSpawn;

    public Arena(String name, Location blueSpawn, Location redSpawn) {
        this.name = name;
        this.blueSpawn = blueSpawn;
        this.redSpawn = redSpawn;
    }

    public String getName() {
        return name;
    }

    public Location getBlueSpawn() {
        return blueSpawn;
    }

    public Location getRedSpawn() {
        return redSpawn;
    }

    public void setBlueSpawn(Location blueSpawn) {
        this.blueSpawn = blueSpawn;
    }

    public void setRedSpawn(Location redSpawn) {
        this.redSpawn = redSpawn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arena arena = (Arena) o;
        return name.equals(arena.name) && blueSpawn.equals(arena.blueSpawn) && redSpawn.equals(arena.redSpawn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, blueSpawn, redSpawn);
    }

    @Override
    public String toString() {
        return "Arena{" +
                "name='" + name + '\'' +
                ", blueSpawn=" + blueSpawn +
                ", redSpawn=" + redSpawn +
                '}';
    }
}
