package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.LightArmor;
import org.project.object.weapons.Dagger;
import org.project.object.weapons.Weapon;

public class Assassin extends Player {

    private boolean isInvisible; // Tracks if the Assassin is invisible.
    private int stealthCooldown; // Turns remaining until stealth can be used again.

    public Assassin() {
        super("Assassin", 100, 70, new Dagger(), new LightArmor());
        this.isInvisible = false;
        this.stealthCooldown = 0; // Cooldown starts at 0 (ability ready to use).
    }


    // Activates stealth mode, making the Assassin invisible for one turn.
    public void uniqAbility(Entity target) {
        if (stealthCooldown == 0) {
            System.out.println(getName() + " has become invisible!");
            isInvisible = true;
            stealthCooldown = 3; // Cooldown period of 3 turns.
        } else {
            System.out.println(getName() + " can't go invisible yet! Cooldown: " + stealthCooldown + " turns.");
        }
    }


    // The Assassin attack method.
    // Deals extra damage if invisible, then cancels invisibility.
    @Override
    public void attack(Entity target) {
        int extraDamage = isInvisible ? 10 : 0; // Bonus damage when invisible.
        System.out.println(getName() + " attacked " + target.getName() + "!");
        System.out.println(isInvisible ? "The attack was enhanced by stealth!" : "");
        target.takeDamage(getWeapon().getDamage() + extraDamage);
        isInvisible = false; // Cancel invisibility after attacking.
    }


    // Assassin takes damage unless they are invisible.
    @Override
    public void takeDamage(int damage) {
        if (isInvisible) {
            System.out.println(getName() + " dodged the attack due to invisibility!");
        } else {
            super.takeDamage(damage);
        }
    }


    // Reduces the stealth cooldown after each turn.
    public void updateCooldown() {
        if (stealthCooldown > 0) {
            stealthCooldown--;
        }
    }
}
