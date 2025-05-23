package org.project.object.armors;

import org.project.entity.Entity;


// Represents a Wizard Robe, an armor for Wizards.
public class WizardRobe extends Armor {

    private int manaRegenBonus; // Extra mana regenerated per turn.

    // Constructs a Wizard Robe with predefined attributes.
    public WizardRobe() {
        super(10, 30); // Defense: 10, Durability: 30.
        this.manaRegenBonus = 5; // Adds 5 mana regeneration per use.
    }

    // Overrides the use method to apply the robe's effect.
    // Restores additional mana to the Wizard wearing it.
    @Override
    public void use(Entity target) {
        if (!isBroke()) {
            System.out.println("The Wizard Robe restores " + manaRegenBonus + " mana to " + target.getName() + "!");
            target.fillMana(manaRegenBonus); // Replenish mana.
            reduceDurability(1); // Decrease durability slightly with each use.
        } else {
            System.out.println("The Wizard Robe is broken and cannot be used!");
        }
    }

    public int getManaRegenBonus() {
        return manaRegenBonus;
    }
}
