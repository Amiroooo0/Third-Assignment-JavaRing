package org.project;

import org.project.entity.players.Assassin;
import org.project.entity.players.Knight;
import org.project.entity.players.Player;
import org.project.entity.players.Wizard;
import org.project.location.Location;
import org.project.object.armors.KnightArmor;
import org.project.object.armors.LightArmor;
import org.project.object.armors.WizardRobe;
import org.project.object.weapons.Dagger;
import org.project.object.weapons.Sword;
import org.project.object.weapons.MagicStaff;
import org.project.Combat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.project.Combat.startFight;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Location> locations = new ArrayList<>();

        Location ancientRuins = new Location("Ancient Ruins", "Crumbling stone ruins with hidden dangers.", 5);
        Location darkForest = new Location("Dark Forest", "A foggy, eerie forest filled with lurking creatures.", 6);
        Location undergroundCrypt = new Location("Underground Crypt", "Dark tunnels where skeletons and undead roam.", 4);
        Location frozenWasteland = new Location("Frozen Wasteland", "An icy tundra where even breathing feels like a battle.", 2);
        Location bloodstainedChapel = new Location("Bloodstained Chapel", "A haunted church with cursed spirits.", 3);
        Location thunderPeak = new Location("Thunder Peak", "A mountaintop constantly struck by lightning.", 4);

        Location currentLocation = frozenWasteland;

        locations.add(ancientRuins);
        locations.add(darkForest);
        locations.add(undergroundCrypt);
        locations.add(frozenWasteland);
        locations.add(bloodstainedChapel);
        locations.add(thunderPeak);

        // TODO: IMPLEMENT GAMEPLAY

        Player player = selectCharacter();

        boolean flag = true;
        while (player.isAlive() && flag) {

            System.out.println("\nWelcome to the " + currentLocation.getName()+"\n     \""+currentLocation.getDescription() + "\".");
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Move to another location 🚶");
            System.out.println("2. Look for enemies to fight ⚔️");
            System.out.println("3. Exit the game ❌");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                {
                    System.out.println("1- Name : Frozen Wasteland Description : An icy tundra where even breathing feels like a battle.");
                    System.out.println("2- Name : Underground Crypt : Dark tunnels where skeletons and undead roam");
                    System.out.println("3- Name : Dark Forest : A foggy, eerie forest filled with lurking creatures.");
                    System.out.println("4- Name : Ancient Ruins : Crumbling stone ruins with hidden dangers.");
                    System.out.println("5- Name : Bloodstained Chapel : A haunted church with cursed spirits.");
                    System.out.println("6- Name : Thunder Peak : A mountaintop constantly struck by lightning.");
                    System.out.print("Please enter your choice : ");

                    int choice2 = scanner.nextInt();

                    switch (choice2) {
                        case 1: currentLocation = frozenWasteland;
                        case 2: currentLocation = undergroundCrypt;
                        case 3: currentLocation = darkForest;
                        case 4: currentLocation = ancientRuins;
                        case 5: currentLocation = bloodstainedChapel;
                        case 6: currentLocation = thunderPeak;
                        default: break;
                    }
                }
                case 2: {
                    Scanner scanner1 = new Scanner(System.in);
                    startFight(player, currentLocation, scanner1);
                    break;
                }
                case 3:
                {
                    flag = false;
                }
            }
        }
    }

    public static Player selectCharacter() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose your character:");
        System.out.println("1: Knight ⚔\uFE0F\uD83D\uDEE1\uFE0F - A sturdy warrior with strong defense.");
        System.out.println("2: Wizard ✨\uD83E\uDDD9\u200D♂\uFE0F✨ - A master of spells and healing.");
        System.out.println("3: Assassin \uD83D\uDDE1\uFE0F - A stealthy attacker with high damage.");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You Selected Arthur (Knight)! - HP: 100, MP: 50, Strong defense.");
                return new Knight();
            case 2:
                System.out.println("You Selected Wizard! - HP: 100, MP: 100 ");
                return new Wizard(25, 20);
            case 3:
                System.out.println("You selected Assassin! - HP: 100, MP: 70 ");
                return new Assassin();
            default:
                System.out.println("Invalid choice. Defaulting to Knight.");
                return new Knight();
        }
    }

}