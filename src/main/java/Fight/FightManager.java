package Fight;

import Abilities.Ability;
import Achievement.Achievement;
import Enemy.Enemy;
import Logger.Logger;
import Utils.IOUtils;


public class FightManager {
    private static final FightManager instance = new FightManager();

    public static boolean startFight(FightablePlayer player, FightableEnemy fightable) {
        System.out.println(Logger.BG_RED + "Fight against: " + fightable.getName() + "." + Logger.RESET);
        return fightable.fight(player, instance);
    }

    public boolean fightPlayerVsEnemy(FightablePlayer player, FightableEnemy enemy) {
        while (true) {
            if (playerKilledEnemy(player, enemy)) break;
            float damageValue;
            damageValue = instance.enemyTurn(enemy);
            damageValue = player.takeDamage(damageValue);
            System.out.println("You lost " + damageValue + "hp.");
            if (player.getCurrentHealth() <= 0) {
                System.out.println("You lost!");
                break;
            }
        }
        player.restore();
        return true;
    }


    public boolean fightPlayerVsBoss(FightablePlayer player, FightableEnemy enemy) {
        while (true) {
            if (playerKilledEnemy(player, enemy)) break;
            float damageValue;
            damageValue = instance.bossTurn(enemy);
            damageValue = player.takeDamage(damageValue);
            System.out.println("You lost " + damageValue + "hp.");
            if (player.getCurrentHealth() <= 0) {
                System.out.println("You lost!");
                break;
            }
        }
        return true;
    }

    public boolean fightPlayerVsAssassin(FightablePlayer player, FightableAssassin enemy) {
        while (true) {
            if (playerKilledEnemy(player, enemy)) return true;
            float damageValue;
            damageValue = instance.assassinTurn(enemy);
            damageValue = player.takeDamage(damageValue);
            System.out.println("You lost " + damageValue + "hp.");
            if (player.getCurrentHealth() <= 0) {
                System.out.println("You lost!");
                break;
            }
        }
        return false;
    }

    public boolean fightPlayerVsGroup(FightablePlayer player, FightableGroup enemy) {
        while (true) {
            if (playerKilledEnemy(player, enemy)) break;
            float damageValue;
            damageValue = instance.enemyGroupTurn(enemy);
            damageValue = player.takeDamage(damageValue);
            System.out.println("You lost " + damageValue + "hp.");
            if (player.getCurrentHealth() <= 0) {
                System.out.println("You lost!");
                break;
            }
        }
        return true;
    }


    public float playerTurn(FightablePlayer player) {
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
        return player.useAbility(choice - 1);
    }

    public float enemyTurn(Fightable enemy) {
        System.out.println("It's enemy Turn " + Logger.BLUE + enemy.getName() + "." + Logger.RESET);
        System.out.println("Enemy current health: " + Logger.RED + enemy.getCurrentHealth() + "." + Logger.RESET);
        return enemy.basicAttack();
    }

    public float enemyGroupTurn(FightableGroup enemy) {
        enemy.removeKilled();
        System.out.println("It's enemy Turn: " + Logger.BLUE + enemy.getName() + "." + Logger.RESET);
        System.out.println(enemy.getName() + " consists of  " + enemy.getGroup().size() + " members.");
        System.out.println(Logger.BG_YELLOW + "                                     " + Logger.RESET);
        var enemiesAlive = enemy.getGroup();
        for (Enemy e : enemiesAlive) {
            System.out.println(e.getName() + " : " + e.getCurrentHealth() + ". ");
        }
        System.out.println(Logger.BG_YELLOW + "                                     " + Logger.RESET);
        return enemy.basicAttack();
    }

    public float bossTurn(FightableEnemy boss) {
        System.out.println("It's boss turn:  " + Logger.BLUE + boss.getName() + "." + Logger.RESET);
        System.out.println("Boss current health: " + Logger.RED + boss.getCurrentHealth() + "." + Logger.RESET);
        if (boss.getCurrentHealth() < 0.9*boss.getHealth()) {
            System.out.println(boss.getName() + "used his ability : " + boss.getAbilities().get(0).getName());
            return boss.getAbilities().get(0).use(boss.getCurrentHealth());
        }
        if (boss.getCurrentHealth() < 0.5*boss.getHealth()) {
            System.out.println(boss.getName() + "used his ability : " + boss.getAbilities().get(1).getName());
            return boss.getAbilities().get(0).use(boss.getCurrentHealth());
        }
        if (boss.getCurrentHealth() < 0.1*boss.getHealth()) {
            System.out.println(boss.getName() + "used his ability : " + boss.getAbilities().get(2).getName());
            return boss.getAbilities().get(2).use(boss.getCurrentHealth());
        }
        return boss.basicAttack();
    }

    public float assassinTurn(FightableAssassin assassin) {
        System.out.println("It's assassin turn:  " + Logger.BLUE + assassin.getName() + "." + Logger.RESET);
        System.out.println("assassin current health: " + Logger.RED + assassin.getCurrentHealth() + "." + Logger.RESET);
        if (assassin.getCurrentHealth() < 0.9 * assassin.getHealth() && assassin.getHealth() > 0.75 * assassin.getHealth()) {
            //System.out.println("In the name of the Order of the Black Knife, die.");
            System.out.println(assassin.getDialoguesList().get(0));
            System.out.println(assassin.getName() + " used his ability : " + assassin.getAbilities().get(0).getName());
            return assassin.getAbilities().get(0).use(assassin.getCurrentHealth());
        }
        if (assassin.getCurrentHealth() < 0.5 * assassin.getHealth() && assassin.getHealth() > 0.25 * assassin.getHealth()) {
            //System.out.println("NOTHING CAN STOP ME." );
            System.out.println(assassin.getDialoguesList().get(1));
            System.out.println(assassin.getName() + "used his ability : " + assassin.getAbilities().get(1).getName());
            return assassin.getAbilities().get(0).use(assassin.getCurrentHealth());
        }
        if (assassin.getCurrentHealth() < 0.1 * assassin.getHealth()) {
            //System.out.println("NO MERCY." );
            System.out.println(assassin.getDialoguesList().get(2));
            System.out.println(assassin.getName() + "used his ability : " + assassin.getAbilities().get(2).getName());
            return assassin.getAbilities().get(2).use(assassin.getCurrentHealth());
        }
        System.out.println("Kiss my knife.");
        return assassin.basicAttack();
    }

    private boolean playerKilledEnemy(FightablePlayer player, FightableEnemy enemy) {
        float damageValue = playerTurn(player);
        System.out.println("You dealt " + damageValue + " damage to Enemy");
        enemy.takeDamage(damageValue);
        if(enemy.getCurrentHealth() <= 0) {
            System.out.println("You won!");
            Achievement.getInstance().message("Player won fight against: " + enemy.getName() + ".", player.getName());
            player.getReward(enemy.getExperience());
            return true;
        }
        return false;
    }

}
