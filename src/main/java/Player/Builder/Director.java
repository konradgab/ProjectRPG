package Player.Builder;

import Abilities.Ability;

import java.util.ArrayList;
import java.util.List;

public class Director {
    Builder builder;

    public Director(Builder b) {
        this.builder = b;
    }

    public void constructEasyMage() {
        builder.setArmor(20);
        builder.setExperience(0);
        builder.setHealth(150);
        builder.setLevel(1);
        builder.setMana(150);
        builder.setAbilities(mageAbilities());
    }

    public void constructMediumMage() {
        builder.setArmor(10);
        builder.setExperience(0);
        builder.setHealth(125);
        builder.setLevel(1);
        builder.setMana(125);
        builder.setAbilities(mageAbilities());
    }

    public void constructHardMage() {
        builder.setArmor(0);
        builder.setExperience(0);
        builder.setHealth(100);
        builder.setLevel(1);
        builder.setMana(100);
        builder.setAbilities(mageAbilities());
    }

    public void constructTestMage() {
        builder.setArmor(100);
        builder.setExperience(0);
        builder.setHealth(10000);
        builder.setLevel(1);
        builder.setMana(100);
        builder.setAbilities(mageAbilities());
    }

    public void constructEasyWarrior() {
        builder.setArmor(50);
        builder.setExperience(0);
        builder.setHealth(200);
        builder.setLevel(1);
        builder.setMana(40);
        builder.setAbilities(warriorAbilities());
    }

    public void constructMediumWarrior() {
        builder.setArmor(40);
        builder.setExperience(0);
        builder.setHealth(150);
        builder.setLevel(1);
        builder.setMana(30);
        builder.setAbilities(warriorAbilities());
    }

    public void constructHardWarrior() {
        builder.setArmor(20);
        builder.setExperience(0);
        builder.setHealth(125);
        builder.setLevel(1);
        builder.setMana(20);
        builder.setAbilities(warriorAbilities());
    }

    public void constructEasyScout() {
        builder.setArmor(25);
        builder.setExperience(0);
        builder.setHealth(150);
        builder.setLevel(1);
        builder.setMana(70);
        builder.setAbilities(scoutAbilities());
    }

    public void constructMediumScout() {
        builder.setArmor(20);
        builder.setExperience(0);
        builder.setHealth(130);
        builder.setLevel(1);
        builder.setMana(50);
        builder.setAbilities(scoutAbilities());
    }

    public void constructHardScout() {
        builder.setArmor(15);
        builder.setExperience(0);
        builder.setHealth(105);
        builder.setLevel(1);
        builder.setMana(30);
        builder.setAbilities(scoutAbilities());
    }

    public List<Ability> mageAbilities() {
        List<Ability> abilities = new ArrayList<>();
        List <Float> multipliers1 = new ArrayList<>();
        List <Float> multipliers2 = new ArrayList<>();
        List <Float> multipliers3 = new ArrayList<>();
        multipliers1.add(1.5f);
        multipliers2.add(1.3f);
        multipliers2.add(1.2f);
        multipliers3.add(1.4f);
        abilities.add(new Ability("Fireball", "Mighty fireball from the abyss of hell.", 5 ,multipliers1));
        abilities.add(new Ability("Heavenly Spear", "Gift given to the wanderers by Zeus.",5 ,multipliers2));
        abilities.add(new Ability("Incubus Light", "Beam of light that blinded the Cyclops.", 4 ,multipliers3));
        return abilities;
    }

    public List<Ability> warriorAbilities() {
        List<Ability> abilities = new ArrayList<>();
        List <Float> multipliers1 = new ArrayList<>();
        List <Float> multipliers2 = new ArrayList<>();
        List <Float> multipliers3 = new ArrayList<>();
        multipliers1.add(1.5f);
        multipliers2.add(1.3f);
        multipliers2.add(1.2f);
        multipliers3.add(1.4f);
        abilities.add(new Ability("Ripper", "Mighty cut, well led out capable of knocking down a mammoth."));
        abilities.add(new Ability("Riposte", "Deliver a blow with incredible precision."));
        abilities.add(new Ability("Bladework", "A quick series of attacks."));
        return abilities;
    }

    public List<Ability> scoutAbilities() {
        List<Ability> abilities = new ArrayList<>();
        List <Float> multipliers1 = new ArrayList<>();
        List <Float> multipliers2 = new ArrayList<>();
        List <Float> multipliers3 = new ArrayList<>();
        multipliers1.add(1.5f);
        multipliers2.add(1.3f);
        multipliers2.add(1.2f);
        multipliers3.add(1.4f);
        abilities.add(new Ability("Archer's focus", "Years in the wilderness have made the scouts' eyes more sensitive. \n Take a precise shot",5 ,multipliers1));
        abilities.add(new Ability("Piercing Arrow", "Fire a powerful shot",5 ,multipliers2));
        abilities.add(new Ability("Hail of arrows", "Fire 10 arrows at once.",4 ,multipliers3));
        return abilities;
    }


}
