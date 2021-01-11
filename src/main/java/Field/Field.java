package Field;

import Actions.IAction;
import Logger.Logger;
import Player.Player;
import Utils.FunctionUtils;
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
    public void displayActions(Player player) {
        if (this.actions.size() != 0) {
            int i = 1;
            for (var x : actions) {
                System.out.println(i + ". " + x.getInfo());
                i++;
            }
            System.out.println("0. Back.");
            System.out.println("Which mission would you like to try: ");
            int choice;
            do {
                choice = IOUtils.nextInt();
                if(choice == 0) return;
                if(!FunctionUtils.checkRange(0, choice ,actions.size())) {
                    System.out.println(Logger.BG_GREEN + "Wrong choice." + Logger.RESET);
                }
            } while (!FunctionUtils.checkRange(0, choice ,actions.size()));
            this.getActions().get(choice-1).execute(player);
        }
        else {
            System.out.println("You have nothing to look for.");
        }
    }
}
