package Fight;

import Abilities.Ability;

import java.util.List;

public interface Fightable {
    public float takeDamage(float damage);

    public float getCurrentHealth();

    public float getCurrentMana();

    public String getName();

    public int getMainAttribute();

    public List<Ability> getAbilities();

    public float basicAttack();

    public boolean fight (Fightable player);
}
