package org.project.object.consumables;

import org.project.object.Object;
import org.project.entity.Entity;

// TODO: UPDATE IMPLEMENTATION
public abstract class Consumable implements Object {

    private int quantity; // Number of times the item can be used.
    private int effectStrength; // Determines the item's impact.

    // Constructs a consumable item.
    public Consumable(int quantity, int effectStrength) {
        this.quantity = quantity;
        this.effectStrength = effectStrength;
    }


     // Consumes the item, applying its effect to the target entity.
     // Reduces the quantity after use.
    @Override
    public void use(Entity target) {
        if (quantity > 0) {
            applyEffect(target);
            quantity--;
            System.out.println("Consumable used. Remaining quantity: " + quantity);
        } else {
            System.out.println("No uses left for this consumable!");
        }
    }

     // Abstract method for applying the consumable's effect.
     // To be implemented by subclasses.
    protected abstract void applyEffect(Entity target);

    // Checks if the consumable is depleted (no remaining uses).
    public boolean isDepleted() {return quantity <= 0;}

    public int getQuantity() {return quantity;}

    public int getEffectStrength() {return effectStrength;}

    /*
    TODO: ADD OTHER REQUIRED AND BONUS METHODS
    */

}
