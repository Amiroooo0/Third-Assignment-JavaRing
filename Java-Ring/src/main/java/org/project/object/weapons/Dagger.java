package org.project.object.weapons;

import org.project.entity.Entity;


// Represents a Dagger, a weapon for Assassins.
public class Dagger extends Weapon {

    private double criticalChance; // Percentage chance to land a critical hit.
    private int criticalMultiplier; // Multiplier for critical damage.

    // Constructs a Dagger with predefined attributes.
    public Dagger() {
        super(12, 3, 20, "Poison Strike"); // Base damage: 12, Mana cost: 3, Durability: 20, Effect: Poison Strike.
        this.criticalChance = 0.25; // 25% chance for a critical hit.
        this.criticalMultiplier = 2; // Critical hits deal double damage.
    }


    // Uses the Dagger to attack the target with a chance of landing a critical hit.
    @Override
    public void use(Entity target) {
        if (Math.random() < criticalChance) { // Determines if critical hit occurs.
            int criticalDamage = getDamage() * criticalMultiplier;
            target.takeDamage(criticalDamage);
            System.out.println("Critical Hit! The Dagger deals " + criticalDamage + " damage to " + target.getName() + "!");
        } else {
            target.takeDamage(getDamage());
            System.out.println("The Dagger deals " + getDamage() + " damage to " + target.getName() + ".");
        }
        reduceDurability(); // Reduce durability after use.
    }

    @Override
    public void uniqAbility(Entity entity) {
        use(entity);
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public int getCriticalMultiplier() {
        return criticalMultiplier;
    }
}
