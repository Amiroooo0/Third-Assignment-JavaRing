package org.project;

import org.project.entity.enemies.Enemy;
import org.project.entity.enemies.Skeleton;
import org.project.entity.players.Player;
import org.project.location.Location;
import org.project.object.consumables.Flask;
import org.project.object.weapons.Weapon;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    private static final Random random = new Random();

    public static void startFight(Player player, Location currentLocation, Scanner scanner) {
        List<Enemy> enemies = currentLocation.getEnemies();
        if (enemies == null || enemies.isEmpty())
        {
            System.out.println("\n⚔️ You scan the area, but no enemies remain.");
            return;
        }

        System.out.println("\n⚔️ Battle begins!");

        
        while (player.getHp() > 0 && !enemies.isEmpty()) {
            
            System.out.println("\n🛡️ Enemies in battle:");
            for (int i = 0; i < enemies.size(); i++) {
                Enemy enemy = enemies.get(i);
                System.out.println((i + 1) + "️⃣ " + enemy.getName() + " - ❤️ " + enemy.getHp() + "/" + enemy.getMaxHP());
            }

            
            int enemyChoice;
            Enemy selectedEnemy = null;
            while (true)
            {
                System.out.print("\nEnter the number of the enemy you wish to attack: ");
                enemyChoice = scanner.nextInt() - 1;
                scanner.nextLine();

                if (enemyChoice >= 0 && enemyChoice < enemies.size())
                {
                    selectedEnemy = enemies.get(enemyChoice);
                    break;
                }
                else
                {
                    System.out.println("\n❌ Invalid choice! Try again.");
                }
            }

            playerAttack(player, selectedEnemy, scanner);

            enemies.removeIf(enemy -> {
                if (enemy.getHp() <= 0) {
                    if (enemy instanceof Skeleton) {
                        Skeleton skeleton = (Skeleton) enemy;
                    }

                    return true;
                }
                return false;
            });

            
            if (enemies.isEmpty()) {
                System.out.println("\n🏆 Victory! The area is now safe.");

                
                if (Math.random() < 0.3) { 
                    if (player.getArmor() != null && player.getArmor().isBroke()) {
                        System.out.println("\n🔧 You find materials to repair your armor!");
                        player.getArmor().repair();
                        System.out.println("🛡️ Your armor has been partially restored.");
                    } else if (player.getArmor() != null) {
                        System.out.println("\n🔧 You find repair materials, but you have no armor to repair.");
                    }
                }

                break;
            }


            player.fillMana(3);
            for (Enemy enemy : enemies) {
                enemy.fillMana(2);
            }

            
            enemyTurn(enemies, player);

            
            if (player.getHp() <= 0) {
                System.out.println("\n💀 You have fallen in battle...");
                return;
            }
        }
    }


    private static void playerAttack(Player player, Enemy enemy, Scanner scanner) {
        System.out.println("\n👤 Player Stats:");
        System.out.println("❤️ HP: " + player.getHp() + "/" + player.getMaxHP());
        System.out.println("🔮 MP: " + player.getMp() + "/" + player.getMaxMP());
        System.out.println("\n⚔️ Choose your action:");
        System.out.println("1️⃣ Normal Attack");
        System.out.println("2️⃣ Super Ability");
        System.out.println("3️⃣ Weapon Ability");
        System.out.println("4️⃣ Use HP Flask 🩹");

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        // boolean attackSuccessful = false;

        switch (choice) {
            case 1:
            {
                player.attack(enemy);
            }
            break;
            case 2:
            {
                player.uniqAbility(enemy);
            }
            break;
            case 3:
            {
                player.getWeapon().uniqAbility(enemy);
            }
            break;
            case 4:
            {
                Flask flask = new Flask();

                flask.applyEffect(player);
            }
            break;
        }
        }

    private static void enemyTurn(List<Enemy> enemies, Player player) {
        if (enemies.isEmpty()) return;

        Enemy attackingEnemy = enemies.get(Combat.random.nextInt(enemies.size()));
        System.out.println("\n⚠️ " + attackingEnemy.getName() + " prepares an attack...");

        boolean attackSuccess=false;
        while (!attackSuccess){
            int enemyAction = Combat.random.nextInt(3);

            switch (enemyAction) {
                case 0:
                    System.out.println("⚔️ " + attackingEnemy.getName() + " attacks you!");
                    attackingEnemy.attack(player);
                    attackSuccess=true;
                    break;

                case 1:
                    if (attackingEnemy.isAlive()) {
                        System.out.println("💥 " + attackingEnemy.getName() + " unleashes a devastating attack!");
                        attackSuccess=true;

                    } else {
                        System.out.println(attackingEnemy.getName() + " tried to use a heavy attack but lacked stamina!");
                    }
                    break;

                case 2:
                    if (attackingEnemy.getWeapon().getManaCost()>= 3 && player.getMp() >= 25) {
                        System.out.println("\n⚡ "+attackingEnemy.getName()+" activate his weapon power!");
                        attackingEnemy.getWeapon().applySpecialEffect(player);
                        attackSuccess = true;
                    }
                    break;
                case 3:
                    if (attackingEnemy.isAlive()) {
                        attackingEnemy.defend();
                        attackSuccess = true;
                    }
                    break;
            }
        }
    }
}