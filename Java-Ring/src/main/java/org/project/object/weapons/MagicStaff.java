package org.project.object.weapons;

import org.project.entity.Entity;

public class MagicStaff extends Weapon {

    private int elementalBonus;


    // Constructs a Magic Staff with predefined attributes.
    public MagicStaff() {
        super(10, 8, 50, "Elemental Blast"); // Damage: 10, Mana Cost: 8, Durability: 50, Effect: Elemental Blast.
        this.elementalBonus = 5; // Adds 5 extra elemental damage.
    }


    // Overrides the use method to include elemental bonus damage.
    @Override
    public void use(Entity target) {
        int totalDamage = getDamage() + elementalBonus;
        target.takeDamage(totalDamage);
        System.out.println("The Magic Staff deals " + totalDamage + " damage, including elemental bonus!");
        reduceDurability();
    }

    @Override
    public void uniqAbility(Entity entity) {
        use(entity);
    }

    public int getElementalBonus() {
        return elementalBonus;
    }
}
