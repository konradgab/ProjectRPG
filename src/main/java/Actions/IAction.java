package Actions;

import Player.Player;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Mission.class, name = "mission"),
        @JsonSubTypes.Type(value = Puzzle.class, name = "puzzle"),
        @JsonSubTypes.Type(value = Tournament.class, name = "tournament")
})
public interface IAction {

    boolean execute(Player player);

     String getInfo();

}
