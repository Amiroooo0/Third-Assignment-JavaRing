package org.project.entity.players;

import org.project.entity.Entity;
import org.project.object.armors.Armor;
import org.project.object.armors.KnightArmor;
import org.project.object.weapons.Sword;
import org.project.object.weapons.Weapon;

// TODO: UPDATE IMPLEMENTATION
public class Knight extends Player {
    // TODO: DESIGN KNIGHT'S WEAPON AND ARMOR AND IMPLEMENT THE CONSTRUCTOR;

    private boolean canUseStrongKick;       // Tracks if the Strong Kick is available.

    public Knight() {
        super("Knight", 100, 50, new Sword(), new KnightArmor());
        this.canUseStrongKick = true; // Initialize with ability available.
    }

    public void uniqAbility(Entity target) {
        if (canUseStrongKick) {
            int strongKickDamage = 25;
            System.out.println(getName() + " used Strong Kick on " + target.getName() + "!");
            target.takeDamage(strongKickDamage);
            canUseStrongKick = false; // Put Strong Kick on cooldown.
        } else {
            System.out.println(getName() + " can't use Strong Kick right now!");
        }
    }

    // Knight's attack method. Includes a chance to use Strong Kick.
    @Override
    public void attack(Entity target) {
        if (canUseStrongKick) {
            uniqAbility(target);
        } else {
            super.attack(target); // Regular attack if Strong Kick isn't available.
        }
    }

    // Allows the Knight to use Strong Kick after some time.
    public void resetStrongKick() {
        this.canUseStrongKick = true;
    }
}
