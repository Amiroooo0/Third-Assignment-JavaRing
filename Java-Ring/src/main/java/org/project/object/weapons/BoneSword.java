package org.project.object.weapons;

import org.project.entity.Entity;

import java.util.ArrayList;

public class BoneSword extends Weapon{

    int abilityCharge;

    // Constructs a BoneSword with specified attributes.
    public BoneSword() {
        super(8, 5, 10, "BoneSword"); // Damage: 8, Mana Cost: 5, Durability: 10, Special Effect: BoneSword.
        this.abilityCharge = 0; // Starts with 0 charge.
    }

    // Increases the ability's charge count after each use.
    public void incrementCharge() {
        abilityCharge++;
        System.out.println("BoneSword's ability charge increased to " + abilityCharge + ".");
    }

    public int getAbilityCharge() {return abilityCharge;}

    // Unique ability
    // Attacks multiple targets with charged damage.
    @Override
    public void uniqAbility(Entity entity) {
        if (abilityCharge >= 3) { // Ability becomes usable after 3 charges.
            System.out.println("Sword unleashes a powerful AoE Slash!");
            {
                entity.takeDamage(getDamage() * 2); // Deals double the Bonesword's base damage.
                System.out.println(entity.getName() + " takes " + (getDamage() * 2) + " damage from AoE Slash!");
            }
            abilityCharge = 0; // Reset ability charge after use.
        } else {
            System.out.println("AoE Slash is not ready yet! (" + abilityCharge + "/3 charges)");
        }
    }
}
