package Fight;


import Enemy.Enemy;

import java.util.List;

public interface FightableGroup extends FightableEnemy {
    public float takeDamage(float damage);

    public float takeDamage(float damage, boolean isAOE);

    public float getCurrentHealth();

    public String getName();

    public float basicAttack();

    public int getLevel();

    public void restore();

    public void removeKilled();

    public List<Enemy> getGroup();


}
