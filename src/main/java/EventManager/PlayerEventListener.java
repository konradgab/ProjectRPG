package EventManager;


import Fight.Fightable;
import Player.Player;

public interface PlayerEventListener {
    void update(String eventType, Player enemy);
}
