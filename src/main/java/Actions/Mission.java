package Actions;

import Enemy.Enemy;
import Fight.FightManager;
import Fight.FightableEnemy;
import Player.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Mission extends Action implements IAction{
    @JsonProperty
    List<FightableEnemy> enemies;
    @JsonProperty
    int reward;

    @Override
    public boolean execute(Player player) {
        for ( var e : enemies) {
            FightManager.startFight(player, e);
        }
        return true;
    }

    @Override
    public String getInfo() {
        System.out.println("Mission: " + this.getName());
        System.out.println("Description: " + this.getDescription());
        return "a";
    }
}
