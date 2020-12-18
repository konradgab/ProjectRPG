package Enemy;

import Abilities.Ability;
import EventManager.PlayerEventListener;
import Fight.FightManager;
import Fight.Fightable;
import Fight.FightableAssassin;
import Player.Player;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor

public class Assassin extends Enemy implements FightableAssassin, PlayerEventListener {


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
        return (float) (0.2 * this.getCurrentHealth());
    }

    @Override
    public void restore() {

    }

    @Override
    public List<String> getDialoguesList() {
        return this.dialogues;
    }

    @Override
    public boolean fight(Fightable player, FightManager fightManager) {
        return false;
    }

    @Override
    public void update(String eventType, Player player) {
        if (player.getLevel() % 10 == 0) {
            FightManager.startFight( player, this);
        }
    }
}
