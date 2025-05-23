package org.project.object.armors;

import org.project.entity.Entity;

// Represents Light Armor designed for Assassins.
public class LightArmor extends Armor {

    private int agilityBonus; // Additional agility provided by the armor.


    // Constructs Light Armor with predefined attributes.
    public LightArmor() {
        super(15, 50); // Defense: 15, Durability: 50.
        this.agilityBonus = 10; // Adds 10 agility, improving evasion or critical hit chances.
    }

    // Provides a special buff to the Assassin wearing it.
    // Increases evasion or movement-related stats (optional for implementation).
    public void applyAgilityBuff() {
        System.out.println("LightArmor grants an agility bonus of " + agilityBonus + " to improve evasive capabilities!");
    }

    // Overrides the use method to reflect Light Armor's effects.
    @Override
    public void use(Entity target) {
        if (!isBroke()) {
            System.out.println("LightArmor reduces damage and enhances agility for " + target.getName() + "!");
            reduceDurability(1); // Reduce durability after use.
        } else {
            System.out.println("The LightArmor is broken and no longer provides agility or defense!");
        }
    }

    public int getAgilityBonus() {
        return agilityBonus;
    }
}
