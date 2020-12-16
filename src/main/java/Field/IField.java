package Field;

import Player.Player;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Field.class, name = "normal"),
})
public interface IField {
    String getName();

    String getDescription();

    void execute(Player player);

    void displayActions();

}
