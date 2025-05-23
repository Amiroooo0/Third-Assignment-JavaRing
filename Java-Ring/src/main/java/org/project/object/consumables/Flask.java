package org.project.object.consumables;

import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public class Flask extends Consumable {

    public Flask() {
        super(3, 2);
    }


    @Override
    public void applyEffect(Entity target) {
        if (!isDepleted()) {
            int healAmount = target.getMaxHP() * 2 / 100; // Calculate the heal amount.
            target.heal(healAmount); // Heal the target.
            System.out.println("Flask restored " + healAmount + " health to " + target.getName() + "!");
            super.use(target); // Reduces the quantity by 1.
        } else {
            System.out.println("The Flask is empty and cannot be used!");
        }
    }

}
