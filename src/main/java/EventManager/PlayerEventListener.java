package EventManager;

import Player.Player;

public interface PlayerEventListener {
    void update(String eventType, Player player);
}
