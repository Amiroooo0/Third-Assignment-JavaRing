package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.consumables.Flask;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public abstract class Player implements Entity {
    Flask flask = new Flask();
    protected String name;
    Weapon weapon;
    Armor armor;
    private int hp;
    private int maxHP;
    private int mp;
    private int maxMP;

    public Player(String name, int hp, int mp, Weapon weapon, Armor armor) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;

        this.maxHP = hp;
        this.maxMP = mp;


        this.weapon = weapon;
        this.armor = armor;
    }

    @Override
    public void attack(Entity target) {
        System.out.println(name + " attacked " + target.getName() + " with " + weapon.getName());
        target.takeDamage(weapon.getDamage());
    }


    public abstract void uniqAbility(Entity target);


    @Override
    public void defend() {
        // TODO: (BONUS) IMPLEMENT A DEFENSE METHOD FOR SHIELDS
    }

    // TODO: (BONUS) UPDATE THE FORMULA OF TAKING DAMAGE
    @Override
    public void takeDamage(int damage) {
        int actualDamage = Math.max(0, damage - armor.getDefense());
        hp -= actualDamage;
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

    @Override
    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public int getMaxHP() {
        return maxHP;
    }

    public int getMp() {
        return mp;
    }

    @Override
    public int getMaxMP() {
        return maxMP;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    // Handle Weapon and Armor Changes

    public void equipWeapon(Weapon newWeapon) {
        this.weapon = newWeapon;
        System.out.println(name + " equipped " + newWeapon.getName());
    }

    public void equipArmor(Armor newArmor) {
        this.armor = newArmor;
        System.out.println(name + " equipped ");
    }


}
