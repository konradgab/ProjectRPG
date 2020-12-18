package Enemy;

import Abilities.Ability;
import Field.Field;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Monster.class, name = "monster"),
        @JsonSubTypes.Type(value = Boss.class, name = "boss"),
        @JsonSubTypes.Type(value = Assassin.class, name = "assassin"),
})
public abstract class Enemy {
    @JsonProperty
    String name;
    @JsonProperty
    int level;
    @JsonProperty
    int experience;
    @JsonProperty
    private float health;
    @JsonProperty
    private float mana;
    @JsonProperty
    private int armor;
    @JsonProperty
    private float currentHealth;
    @JsonProperty
    private float currentMana;
    @JsonProperty
    List<Ability> abilities;
    @JsonProperty
    List<String> dialogues;


}
