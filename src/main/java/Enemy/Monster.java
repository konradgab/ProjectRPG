package Enemy;

import Abilities.Ability;
import Fight.FightManager;
import Fight.Fightable;
import lombok.Getter;

import java.util.List;

@Getter
public class Monster extends Enemy implements Fightable {


    public Monster(String name, float health, float mana, int armor, float currentHealth, float currentMana, List<Ability> Abilities, List<String> dialogues) {
        super(name, health, mana, armor, currentHealth, currentMana, Abilities, dialogues);
    }

    @Override
    public float takeDamage(float damage) {
        this.setCurrentHealth(this.getCurrentHealth() - damage);
        return damage;
    }


    @Override
    public float basicAttack() {
        return (float) (0.5*this.getHealth() + (0.1)*(this.getHealth() - this.getCurrentHealth()));
    }

    @Override
    public boolean fight(Fightable player) {
        return FightManager.fightPlayerVsEnemy(player, this);
    }

    @Override
    public int getMainAttribute() {
        return (int) this.getHealth();
    }

    @Override
    public List<Ability> getAbilities() {
        return null;
    }


}


// shapem jest fightable
// visitorami sa np Monster , Boss
// XMLExportem jest fight Manager
