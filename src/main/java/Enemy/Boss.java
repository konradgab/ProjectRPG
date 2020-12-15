package Enemy;

import Abilities.Ability;
import Fight.FightManager;
import Fight.Fightable;
import Fight.FightableEnemy;

import java.util.List;

public class Boss extends Enemy implements FightableEnemy {


    public Boss(String name, float health, float mana, int armor, float currentHealth, float currentMana, List<Ability> Abilities, List<String> dialogues) {
        super(name, health, mana, armor, currentHealth, currentMana, Abilities, dialogues);
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
    public boolean fight(Fightable player, FightManager fightManager) {
        return fightManager.fightPlayerVsBoss(player, this);
    }
}
