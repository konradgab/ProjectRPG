package Player.Builder;

import Abilities.Ability;
import Player.Player;

import java.util.List;

public interface Builder {
    public void reset();
    public void setHealth(float value);
    public void setMana(float value);
    public void setExperience(int value);
    public void setArmor(int value);
    public void setLevel(int value);
    public void setName(String name);
    public void setAbilities(List<Ability> abilities);

}
