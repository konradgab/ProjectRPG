package Enemy;

import Abilities.Ability;
import Fight.FightManager;
import Fight.FightableEnemy;
import Fight.FightablePlayer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Monster extends Enemy implements FightableEnemy {


    @Override
    public float takeDamage(float damage) {
        this.setCurrentHealth(this.getCurrentHealth() - damage);
        return damage;
    }


    @Override
    public float basicAttack() {
        return (float) (0.5 * this.getHealth() + (0.1) * (this.getHealth() - this.getCurrentHealth()));
    }

    @Override
    public void restore() {

    }

    @Override
    public boolean fight(FightablePlayer player, FightManager fightManager) {
        return fightManager.fightPlayerVsEnemy(player, this);
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

