package Fight;

import Abilities.Ability;
import Logger.Logger;
import Utils.IOUtils;


public class FightManager {
    private static final FightManager instance = new FightManager();

    public static boolean startFight(Fightable player, Fightable fightable) {
        return fightable.fight(player);
    }

    public static boolean fightPlayerVsEnemy(Fightable player, Fightable enemy) {
        while (true) {
            float damageValue = playerTurn(player);
            System.out.println("You dealt " + damageValue + " damage to Enemy");
            enemy.takeDamage(damageValue);
            if(enemy.getCurrentHealth() <= 0) {
                System.out.println("You won!");
                break;
            }
            damageValue = enemyTurn(enemy);
            damageValue = player.takeDamage(damageValue);
            System.out.println("You lost " + damageValue + "hp.");
            if(player.getCurrentHealth() <= 0) {
                System.out.println("You lost!");
                break;
            }
        }
        return true;
    }

    public static boolean fightPlayerVsBoss(Fightable player, Fightable enemy) {
        while (true) {
            float damageValue = playerTurn(player);
            System.out.println("You dealt " + damageValue + " damage to Enemy");
            enemy.takeDamage(damageValue);
            if(enemy.getCurrentHealth() <= 0) {
                System.out.println("You won!");
                break;
            }
            damageValue = bossTurn(enemy);
            damageValue = player.takeDamage(damageValue);
            System.out.println("You lost " + damageValue + "hp.");
            if(player.getCurrentHealth() <= 0) {
                System.out.println("You lost!");
                break;
            }
        }
        return true;
    }



    public static float playerTurn(Fightable player) {
        System.out.println("It's your turn " + Logger.BLUE + player.getName() + "." + Logger.RESET);
        System.out.println("Your current health: " + Logger.RED + player.getCurrentHealth() + "." + Logger.RESET);
        System.out.println("Your current mana: " + Logger.RED + player.getCurrentMana() + "." + Logger.RESET);
        System.out.println(Logger.BG_RED + "Choose your attack: " + Logger.RESET);
        int i = 1;
        for (Ability ability : player.getAbilities()) {
            System.out.println(Logger.GREEN + i + Logger.RESET + ". " + ability.getName() + " cost: " + ability.getCost() + ".");
            i++;
        }
        System.out.println(Logger.GREEN + i + Logger.RESET + ". " + "Basic Attack.");
        int choice = IOUtils.getScanner().nextInt();
        if (choice - 1 >= player.getAbilities().size()) {
            return player.basicAttack();
        }
        if (player.getAbilities().get(choice - 1).getCost() > player.getCurrentMana()) {
            System.out.println("Ups, You didn't have enough mana.");
            return 0;
        }
        return player.getAbilities().get(choice - 1).use(player.getMainAttribute());
    }

    public static float enemyTurn(Fightable enemy) {
        System.out.println("It's enemy Turn " + Logger.BLUE + enemy.getName() + "." + Logger.RESET);
        System.out.println("Enemy current health: " + Logger.RED + enemy.getCurrentHealth() + "." + Logger.RESET);
        return enemy.basicAttack();
    }

    public static float bossTurn(Fightable boss) {
        System.out.println("It's enemy turn:  " + Logger.BLUE + boss.getName() + "." + Logger.RESET);
        System.out.println("Boss current health: " + Logger.RED + boss.getCurrentHealth() + "." + Logger.RESET);
        if(boss.getCurrentHealth() < 90) {
            System.out.println(boss.getName() + "used his ability : " + boss.getAbilities().get(0).getName());
            return boss.getAbilities().get(0).use(boss.getCurrentHealth());
        }
        if(boss.getCurrentHealth() < 50) {
            System.out.println(boss.getName() + "used his ability : " + boss.getAbilities().get(1).getName());
            return boss.getAbilities().get(0).use(boss.getCurrentHealth());
        }
        if(boss.getCurrentHealth() < 10) {
            System.out.println(boss.getName() + "used his ability : " + boss.getAbilities().get(2).getName());
            return boss.getAbilities().get(2).use(boss.getCurrentHealth());
        }
        return boss.basicAttack();
    }


}