package Player.Builder;

import Abilities.Ability;
import Player.PlayerScout;
import lombok.Getter;

import java.util.List;

@Getter
public class ScoutBuilder implements Builder {
    PlayerScout product;

    ScoutBuilder(String name) {
        this.reset();
    }

    @Override
    public void reset() {
        this.product = new PlayerScout();
    }

    @Override
    public void setHealth(float value) {
        product.setHealth(value);
        product.setCurrentHealth(value);
    }

    @Override
    public void setMana(float value) {
        product.setMana(value);
    }

    @Override
    public void setExperience(int value) {
        product.setExperience(value);
    }

    @Override
    public void setArmor(int value) {
        product.setArmor(value);
    }

    @Override
    public void setLevel(int value) {
        product.setLevel(value);
    }

    @Override
    public void setName(String name) {
        product.setName(name);
    }

    @Override
    public void setAbilities(List<Ability> abilities) {
        product.setAbilities(abilities);
    }

}
