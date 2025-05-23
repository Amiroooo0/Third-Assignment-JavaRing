package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.entity.players.Player;
import org.project.object.weapons.BoneSword;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Skeleton extends Enemy{
    // TODO: DESIGN ENEMY'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR

    private boolean hasResurrected; // Tracks if the skeleton has already resurrected.

    public Skeleton(int hp, int mp, Weapon weapon) {
        super(hp, mp, new BoneSword(), "Skeleton");
        this.hasResurrected = false; // Initially, the skeleton has not resurrected.
    }



    // Skeleton unique ability: Resurrection.
     // Revives the skeleton with half its maximum health after being defeated.
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        if (!isAlive() && !hasResurrected) {
            System.out.println(getClass().getSimpleName() + " has been defeated but is resurrecting!");
            hasResurrected = true;
            restoreHealth(getMaxHP() / 2); // Revives with half max health.
        } else if (!isAlive()) {
            System.out.println(getClass().getSimpleName() + " is truly defeated!");
        }
    }


     // Implements Skeleton's attack method using its weapon.
    @Override
    public void attack(Entity target) {
        System.out.println(getClass().getSimpleName() + " swings its " + getWeapon().getName() + " at " + target.getName() + "!");
        target.takeDamage(getWeapon().getDamage());
    }


     // Skeleton's special actions or abilities in battle can be added here.
    @Override
    public void useAbility(Entity target) {
        // Skeletons could have minimal special abilities; keep it simple or expand for fun.
        System.out.println(getClass().getSimpleName() + " rattles and prepares to attack!");
    }


    // Restores a portion of health to the skeleton.
    private void restoreHealth(int health) {
        System.out.println(getClass().getSimpleName() + " restores itself to battle!");
        int newHP = Math.min(getHp() + health, getMaxHP());
    //  setHp(newHP); // Custom setter for HP may be needed in parent class.
    }
}
