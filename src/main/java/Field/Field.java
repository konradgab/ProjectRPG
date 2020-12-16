package Field;

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
    protected List<Missions> actions;
    @JsonProperty
    private ICard undefeatedCard;
    @JsonProperty
    protected int mapLevel;

}
