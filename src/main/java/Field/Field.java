package Field;

import Actions.IAction;
import Actions.Mission;
import Player.Player;
import Utils.IOUtils;
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
    public int displayActions(Player player) {
        int i = 1;
        for ( var x : actions) {
            System.out.println(i + ". " + x.getInfo());
            i++;
        }
        System.out.println("Which mission would you like to try: ");
        int choice = IOUtils.nextInt();
        actions.get(choice-1).execute(player);
        return 0;
    }
}
