package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.RustyDagger;
import org.project.object.weapons.Weapon;

import java.util.List;

public class Dragon extends Enemy{

    public Dragon(int hp, int mp) {
        super(hp, mp, null, "Dragon"); // Dragons may not use traditional weapons.
    }


     // Dragon's powerful single-target attack.
     // Ignores armor or defense systems.
    @Override
    public void attack(Entity target) {
        System.out.println(getClass().getSimpleName() + " breathes fire at " + target.getName() + "!");
        target.takeDamage(25); // Assumes maximum possible damage for single-target attack.
    }


     // Dragon's area-of-effect ability: Flame Breath.
     // Damages all entities in the specified list.
    public void useFlameBreath(List<Entity> targets) {
        System.out.println(getClass().getSimpleName() + " unleashes Flame Breath, scorching everything in its path!");
        for (Entity target : targets) {
            target.takeDamage(getMaxDamage() / 2); // AoE attacks usually deal reduced damage.
            System.out.println(target.getName() + " was scorched!");
        }
    }

    @Override
    public void useAbility(Entity target) {
        System.out.println(getClass().getSimpleName() + " prepares a devastating attack!");
    }

    // Returns the maximum possible damage the Dragon can inflict.
    private int getMaxDamage() {
        return 50; // damage value.
    }

}
