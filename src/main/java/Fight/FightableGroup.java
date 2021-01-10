package Fight;

import Abilities.Ability;

import java.util.List;

public interface FightableGroup {
    public float takeDamage(float damage);

    public float takeDamage(float damage, boolean isAOE);

    public float getCurrentHealth();

    public String getName();

    public float basicAttack();

    public int getLevel();

    public void restore();

    public void removeKilled();


}
