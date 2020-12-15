package Enemy;

import Abilities.Ability;
import Fight.Fightable;

import java.util.List;

public class Boss extends Enemy implements Fightable {

    public Boss(String name, float health, float mana, int armor, float currentHealth, float currentMana, List<Ability> Abilities) {
        super(name, health, mana, armor, currentHealth, currentMana, Abilities);
    }

    @Override
    public float takeDamage(float damage) {
        return 0;
    }

    @Override
    public int getMainAttribute() {
        return (int) getHealth();
    }

    @Override
    public float basicAttack() {
        return 0;
    }

    @Override
    public boolean fight(Fightable player) {
        return false;
    }
}
