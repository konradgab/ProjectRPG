package EventManager;

import Fight.Fightable;
import Player.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerEventManager {
    Map<String, List<PlayerEventListener>> listeners = new HashMap<>();

    public PlayerEventManager(String... operations) {
        for (String operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, PlayerEventListener listener) {
        List<PlayerEventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, PlayerEventListener listener) {
        List<PlayerEventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, Player player) {
        List<PlayerEventListener> users = listeners.get(eventType);
        for (PlayerEventListener listener : users) {
            listener.update(eventType, player);
        }
    }
}
