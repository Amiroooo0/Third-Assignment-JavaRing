package org.project.object.armors;

import org.project.object.Object;

// TODO: UPDATE IMPLEMENTATION
public abstract class Armor implements Object {
    private int defense;
    private int maxDefense;
    private int durability;
    private int maxDurability;

    private boolean isBroke;

    public Armor(int defense, int durability) {
        this.defense = defense;
        this.maxDefense = defense;
        this.durability = durability;
        this.maxDurability = durability;
        this.isBroke = false;
    }

    // Checks if the armor is broken and updates its status.
    public void checkBreak() {
        if (durability <= 0) {
            isBroke = true;
            defense = 0;
            System.out.println("The armor has broken and no longer provides defense!");
        }
    }

    // Repairs the armor, restoring its defense and durability to maximum.
    public void repair() {
        if (isBroke) {
            isBroke = false;
            defense = maxDefense;
            durability = maxDurability;
            System.out.println("The armor has been repaired to full durability and defense!");
        } else {
            System.out.println("Armor is not broken and does not need repair.");
        }
    }


    // Reduces the armor's durability by a specified amount and checks if it's broken.
    public void reduceDurability(int amount) {
        durability = Math.max(durability - amount, 0);
        checkBreak();
    }


    // Enhances the armor, increasing its maximum defense and durability.
    public void enhance(int enhancementBonus) {
        maxDefense += enhancementBonus;
        maxDurability += enhancementBonus;
        System.out.println("The armor has been enhanced! Max defense is now " + maxDefense +
                " and max durability is " + maxDurability + ".");
    }

    public int getDefense() {
        return defense;
    }

    public int getDurability() {
        return durability;
    }

    public boolean isBroke() {
        return isBroke;
    }

    public int getMaxDefense() {
        return maxDefense;
    }

    public int getMaxDurability() {
        return maxDurability;

    }

}
