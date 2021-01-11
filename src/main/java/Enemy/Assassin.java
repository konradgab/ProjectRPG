package Enemy;

import EventManager.PlayerEventListener;
import Fight.FightManager;
import Fight.FightableAssassin;
import Fight.FightablePlayer;
import Player.Player;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor

public class Assassin extends Enemy implements FightableAssassin, PlayerEventListener {


    @Override
    public float takeDamage(float damage) {
        var health = getCurrentHealth();
        if (this.getArmor() >= 0) {
            setCurrentHealth((float) (health - ((1 / (0.1 * (getArmor() + 1)) * damage))));
        } else {
            setCurrentHealth(health - damage);
        }
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
    public void update(String eventType, Player player) {
        if (player.getLevel() % 10 == 0) {
            FightManager.startFight( player, this);
        }
    }

    @Override
    public boolean fight(FightablePlayer player, FightManager fightManager) {
        return fightManager.fightPlayerVsAssassin(player, this);
    }
}
