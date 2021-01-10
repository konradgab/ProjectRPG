package Fight;

import Abilities.Ability;

import java.util.List;

public interface Fightable {
    public float takeDamage(float damage);

    public float getCurrentHealth();

    default float getCurrentMana() {
        return 0;
    }

    public String getName();

    public int getMainAttribute();

    public List<Ability> getAbilities();

    public float basicAttack();

    public int getLevel();

    public void restore();

}
