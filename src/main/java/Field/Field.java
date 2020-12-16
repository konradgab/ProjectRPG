package Field;

import Actions.IAction;
import Actions.Mission;
import Player.Player;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
@Getter
public class Field implements IField {
    @JsonProperty
    protected String name;
    @JsonProperty
    protected String description;
    @JsonProperty
    protected List<IAction> actions;

    @Override
    public void execute(Player player) {
        actions.get(0).execute(player);

    }

    @Override
    public void displayActions() {
        for ( var x : actions) {
            x.getInfo();
        }
    }
}
