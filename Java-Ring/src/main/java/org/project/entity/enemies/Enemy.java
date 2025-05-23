package org.project.entity.enemies;

import org.project.entity.Entity;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Enemy implements Entity {
    protected String name;
    private Weapon weapon;
    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;

    public Enemy(int hp, int mp, Weapon weapon, String name) {
        this.hp = hp;
        this.maxHP = hp;
        this.mp = mp;
        this.maxMP = mp;
        this.weapon = weapon;
        this.name = name;
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage); // Ensure no negative damage.
        hp -= actualDamage;
        hp = Math.max(hp, 0); // Ensure HP doesn't go below 0.
        System.out.println(getClass().getSimpleName() + " took " + actualDamage + " damage! HP remaining: " + hp);
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getName() {
        return name;
    }


    @Override
    public void defend() {
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS
    }


    @Override
    public void heal(int health) {
        hp += health;
        if (hp > maxHP) {
            hp = maxHP;
        }
    }

    @Override
    public void fillMana(int mana) {
        mp += mana;
        if (mp > maxMP) {
            mp = maxMP;
        }
    }


    // Placeholder for unique enemy abilities, to be implemented in subclasses.
    public abstract void useAbility(Entity target);


    // Restores mana to the enemy.
    public void restoreMana(int mana) {
        mp = Math.min(mp + mana, maxMP); // Prevent exceeding maximum mana.
        System.out.println(getClass().getSimpleName() + " restored " + mana + " mana. MP: " + mp + "/" + maxMP);
    }

}
