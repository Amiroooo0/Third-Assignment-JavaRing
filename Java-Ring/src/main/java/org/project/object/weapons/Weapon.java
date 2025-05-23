package org.project.object.weapons;

import org.project.entity.Entity;
import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Weapon implements Object {
    private String name;
    private int damage;
    private int manaCost;
    private int durability; // Tracks weapon usage.
    private String specialEffect; // Unique effects like poison or fire damage.

    /*
    TODO: ADD OTHER REQUIRED AND BONUS ATTRIBUTES
    */

    // Constructs a weapon with specified attributes.(damage, manaCost, durability, specialEffect)
    public Weapon(int damage, int manaCost, int durability, String specialEffect) {
        this.damage = damage;
        this.manaCost = manaCost;
        this.durability = durability;
        this.specialEffect = specialEffect;
    }

    // Uses the weapon against a target entity, applying damage and special effects.
    @Override
    public void use(Entity target) {
        if (durability > 0) {
            target.takeDamage(damage);
            applySpecialEffect(target); // Apply special effects if available.
            reduceDurability();
        } else {
            System.out.println("The weapon is too worn out to be used!");
        }
    }

    public abstract void uniqAbility(Entity entity);

    public int getDamage() {
        return damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public String getName() {return name;}

    public int getDurability() {return durability;}

    public String getSpecialEffect() {return specialEffect;}

    // Reduces the weapon's durability after use.
    public void reduceDurability() {
        durability--;
        System.out.println("Weapon durability reduced to " + durability + ".");
    }


    // Applies special effects to the target (e.g., poison, fire).
    public void applySpecialEffect(Entity target) {
        if (specialEffect != null && !specialEffect.isEmpty()) {
            System.out.println("Applying special effect: " + specialEffect + " to " + target.getName() + "!");
        }
    }

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */
}
