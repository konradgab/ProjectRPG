package Enemy;

import Abilities.Ability;
import Fight.FightableGroup;
import Logger.Logger;
import lombok.AllArgsConstructor;

import javax.management.ConstructorParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemiesGroup implements FightableGroup {
    String name;
    public List<Enemy> group;
    Random rand = new Random();

    EnemiesGroup(String name, List<Enemy> group) {
        this.name = name;
        this.group = group;
    }

    public void add(Enemy e) {
        group.add(e);
    }

    public void remove(Enemy e) {
        group.remove(e);
    }


    @Override
    public float takeDamage(float damage) {
        int whoTakeDamage = rand.nextInt(group.size());
        return group.get(whoTakeDamage).takeDamage(damage);
    }

    @Override
    public float takeDamage(float damage, boolean isAOE) {
        for (var e : group) {
            e.takeDamage(damage);
        }
        return damage;
    }

    @Override
    public float getCurrentHealth() {
        float health = 0;
        removeKilled();
        System.out.println(this.getName() + " consists of  " + group.size() + " members.");
        System.out.println(Logger.BG_YELLOW + "                                     " + Logger.RESET);
        for (var e : group) {
            System.out.println(e.getName() + " : " + e.getCurrentHealth() + ". ");
            health = health + e.getCurrentHealth();
        }
        System.out.println(Logger.BG_YELLOW + "                                     " + Logger.RESET);
        return health;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public float basicAttack() {
        int whoAttack = rand.nextInt(group.size());
        return group.get(whoAttack).basicAttack();
    }


    @Override
    public int getLevel() {
        int level = 0;
        for (var e : group) {
            level += e.getLevel();
        }
        return group.size() != 0 ? level / group.size() : 0;
    }

    @Override
    public void restore() {
        for (var e : group) {
            e.restore();
        }
    }

    @Override
    public void removeKilled() {
        for (var e : group) {
            if (e.getCurrentHealth() <= 0) {
                this.remove(e);
            }
        }
    }
}
