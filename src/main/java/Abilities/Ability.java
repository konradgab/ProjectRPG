package Abilities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Ability {
    @JsonProperty
    String name;
    @JsonProperty
    String description;
    @JsonProperty
    double cost;
    @JsonProperty
    List<Float> multipliers;

    public Ability(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public float use(float x) {
        return multipliers.get(0) * x;
    }

    public float use(float x, float y) {
        return multipliers.get(0) * x + multipliers.get(1) * y;
    }

    public float use(float x, float y, float z) {
        return multipliers.get(0) * x + multipliers.get(1) * y + multipliers.get(2) * z;
    }


}
