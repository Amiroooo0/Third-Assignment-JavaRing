package org.project.location;

import org.project.entity.enemies.Dragon;
import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Goblin;
import org.project.entity.enemies.Skeleton;
import org.project.object.weapons.BoneSword;
import org.project.object.weapons.RustyDagger;

import java.util.ArrayList;

public class Location {

    private String name;
    private String description;
    private int numEnemies;

    private ArrayList<Location> locations;
    private ArrayList<Enemy> enemies;

    public Location(String name, String description, int numEnemies) {
        this.name = name;
        this.description = description;
        this.numEnemies = numEnemies;

        locations = new ArrayList<>();
        enemies = new ArrayList<>();

        for (int i = 0; i < numEnemies; i++) {
            enemies.add(spawnRandomEnemy());
        }
    }


    private Enemy spawnRandomEnemy() {
        int rand = (int) (Math.random() % 3 + 1);

        switch (rand) {
            case 1: return new Skeleton(25, 25, new BoneSword());
            case 2: return new Goblin(25, 25, new RustyDagger());
            case 3: return new Dragon(30, 30);
            default: return new Skeleton(25, 25, new BoneSword());
        }

    }

    public void resetLocation() {
        enemies.clear(); // Remove current enemies
        System.out.println("Location has been reset.");
    }


    public String getName() {
        return name;
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public String getDescription() {
        return description;
    }
}
