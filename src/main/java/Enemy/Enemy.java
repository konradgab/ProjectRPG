package Enemy;

import Abilities.Ability;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public abstract class Enemy {
    String name;
    private float health;
    private float mana;
    private int armor;
    private float currentHealth;
    private float currentMana;
    List<Ability> Abilities;


}
