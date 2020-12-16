package Actions;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Action implements IAction {
    @JsonProperty
    String name;
    @JsonProperty
    String description;


}
