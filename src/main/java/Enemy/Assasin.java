package Enemy;

import Abilities.Ability;
import Fight.FightManager;
import Fight.Fightable;
import Fight.FightableAssassin;

import java.util.List;

public class Assasin extends Enemy implements FightableAssassin {


    public Assasin(String name, float health, float mana, int armor, float currentHealth, float currentMana, List<Ability> Abilities, List<String> dialogues) {
        super(name, health, mana, armor, currentHealth, currentMana, Abilities, dialogues);
    }

    @Override
    public float takeDamage(float damage) {
        setCurrentHealth((float) (getCurrentHealth() - ((1 / (0.1 * getArmor())) * damage)));
        return (float) ((1 / (0.1 * getArmor())) * damage);
    }

    @Override
    public int getMainAttribute() {
        return (int) this.getCurrentHealth();
    }

    @Override
    public float basicAttack() {
        return (float) (0.2* this.getCurrentHealth());
    }

    @Override
    public List<String> getDialoguesList() {
        return this.dialogues;
    }

    @Override
    public boolean fight(Fightable player, FightManager fightManager) {
        return false;
    }
}
