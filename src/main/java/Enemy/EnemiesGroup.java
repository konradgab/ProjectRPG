package Enemy;

import Abilities.Ability;
import Fight.FightManager;
import Fight.FightableGroup;
import Fight.FightablePlayer;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class EnemiesGroup implements FightableGroup {
    String name;
    public List<Enemy> group;
    Random rand = new Random();
     int experience = 0;

    public EnemiesGroup(String name, List<Enemy> group) {
        this.name = name;
        this.group = group;
    }

    public EnemiesGroup(String name) {
        this.name = name;
        group = new ArrayList<>();
    }

    public void add(Enemy e) {
        group.add(e);
        this.experience = this.experience + e.getExperience();
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
        for (var e : group) {
            health = health + e.getCurrentHealth();
        }
        return health;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getMainAttribute() {
        return 0;
    }

    @Override
    public List<Ability> getAbilities() {
        return null;
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
        int i = 0;
        group.removeIf(e -> e.getCurrentHealth() <= 0);
    }

    @Override
    public boolean fight(FightablePlayer player, FightManager fightManager) {
        return fightManager.fightPlayerVsGroup(player, this);
    }

    @Override
    public int getExperience() {
        return 0;
    }

    @Override
    public float getHealth() {
        return 0;
    }
}
