package Fight;

import Enemy.Assassin;
import Enemy.Boss;
import Enemy.Monster;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Monster.class, name = "monster"),
        @JsonSubTypes.Type(value = Boss.class, name = "boss"),
        @JsonSubTypes.Type(value = Assassin.class, name = "assassin"),
})
public interface FightableEnemy extends Fightable{
    public boolean fight (Fightable player, FightManager fightManager);
}
