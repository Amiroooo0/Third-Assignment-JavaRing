package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.WizardRobe;
import org.project.object.weapons.MagicStaff;
import org.project.object.weapons.Weapon;

public class Wizard extends Player {

    private final int spellDamage; // Damage dealt by a spell.
    private final int healAmount; // Health restored by healing spells.

    public Wizard(int spellDamage, int healAmount) {
        super("Wizard", 100, 100, new MagicStaff(), new WizardRobe());
        this.spellDamage = spellDamage;
        this.healAmount = healAmount;
    }


    // Casts a damaging spell at the target entity.
    // Consumes mana for the spell.
    public void uniqAbility(Entity target) {
        int manaCost = 10; // Example mana cost for the spell.
        if (getMp() >= manaCost) {
            fillMana(-manaCost); // Deduct mana.
            System.out.println(getName() + " cast a powerful spell on " + target.getName() + "!");
            target.takeDamage(spellDamage);
        } else {
            System.out.println(getName() + " does not have enough mana to cast a spell!");
        }
    }


    // Casts a healing spell to restore the Wizard's health.
    // Consumes mana for the spell.
    public void castHealingSpell() {
        int manaCost = 8;
        if (getMp() >= manaCost) {
            fillMana(-manaCost); // Deduct mana.
            heal(healAmount); // Heal the Wizard.
            System.out.println(getName() + " cast a healing spell and restored " + healAmount + " HP!");
        } else {
            System.out.println(getName() + " does not have enough mana to cast a healing spell!");
        }
    }


    // Overrides the attack method to include spellcasting in addition to physical attacks.
    @Override
    public void attack(Entity target) {
        System.out.println(getName() + " attacked " + target.getName() + " using " + getWeapon().getName());
        target.takeDamage(getWeapon().getDamage());
    }


    // Prints the Wizard's current mana for better gameplay visibility.
    public void displayMana() {
        System.out.println(getName() + " has " + getMp() + " mana remaining.");
    }
}
