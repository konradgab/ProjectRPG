package Abilities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
public class Ability {
    String name;
    String description;
    double cost;
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
