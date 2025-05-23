package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

public class RustyDagger extends Weapon {

    int abilityCharge;

    // Constructs a Rusty Dagger with specified attributes.
    public RustyDagger() {
        super(8, 5, 10, "Rusty Dagger");
    }

    // Unique ability
    // Attacks multiple targets with charged damage.
    @Override
    public void uniqAbility(Entity entity) {
        if (abilityCharge >= 3) { // Ability becomes usable after 3 charges.
            System.out.println("RustyDagger unleashes a powerful Slash!");
            {
                entity.takeDamage(getDamage() * 2); // Deals double the RustyDagger's base damage.
                System.out.println(entity.getName() + " takes " + (getDamage() * 2) + " damage!");
            }
            abilityCharge = 0; // Reset ability charge after use.
        } else {
            System.out.println("Slash is not ready yet! (" + abilityCharge + "/3 charges)");
        }
    }

    // Increases the ability's charge count after each use.
    public void incrementCharge() {
        abilityCharge++;
        System.out.println("Sword's ability charge increased to " + abilityCharge + ".");
    }

    public int getAbilityCharge() {return abilityCharge;}

}
