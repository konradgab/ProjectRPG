package Actions;

import Player.Player;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Puzzle implements IAction{
    @JsonProperty
    String desription;
    @Override
    public boolean execute(Player player) {
        return false;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
