package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.RustyDagger;
import org.project.object.weapons.Weapon;

public class Goblin extends Enemy{

    public Goblin(int hp, int mp, Weapon weapon) {
        super(hp, mp, new RustyDagger(), "Goblin");
    }


    // Goblin's attack method: Performs a basic weapon attack.
    @Override
    public void attack(Entity target) {
        System.out.println(getClass().getSimpleName() + " slashes at " + target.getName() + " with its " + getWeapon().getName() + "!");
        target.takeDamage(getWeapon().getDamage());
    }


     // Goblin does not have any special abilities.
     // This method is left empty for consistency.
    @Override
    public void useAbility(Entity target) {
        System.out.println(getClass().getSimpleName() + " snarls but has no special abilities to use.");
    }
}
