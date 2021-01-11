package Enemy;

import Fight.FightManager;
import Fight.FightableEnemy;
import Fight.FightablePlayer;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Boss extends Enemy implements FightableEnemy {

    @Override
    public float takeDamage(float damage) {
        setCurrentHealth(getCurrentHealth() - damage);
        return damage;
    }

    @Override
    public int getMainAttribute() {
        return (int) getHealth();
    }

    @Override
    public float basicAttack() {
        return 0.5f* getCurrentHealth();
    }

    @Override
    public int getLevel() {
        return 0;
    }

    @Override
    public void restore() {

    }

    @Override
    public boolean fight(FightablePlayer player, FightManager fightManager) {
        return fightManager.fightPlayerVsBoss(player, this);
    }
}
