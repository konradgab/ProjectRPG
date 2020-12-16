package Player;
import Abilities.Ability;
import EventManager.PlayerEventManager;
import Fight.Fightable;
import Utils.IOUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public abstract class Player implements Fightable {
    PlayerEventManager eventManager = new PlayerEventManager("level up");
    String name;
    private int level;
    private float health;
    private float mana;
    private int experience;
    private int armor;
    private float currentHealth;
    private float currentMana;
    List <Ability> abilities;

    Player(){
        this.level = 0;
        this.health = 0;
        this.mana = 0;
        this.experience = 0;
        this.armor = 0;
        this.currentHealth = 0;
        this.currentMana = 0;
    }

    Player(String name){
        this.name = name;
        this.level = 0;
        this.health = 0;
        this.mana = 0;
        this.experience = 0;
        this.armor = 0;
        this.currentHealth = 0;
        this.currentMana = 0;
    }

    public void displayStatistics() {
        System.out.println("Your statistics: ");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("Health: " + health);
        System.out.println("Mana: " + mana);
        System.out.println("Experience: " + experience);
        System.out.println("Armor: " + armor);
    }

    public void printAbilities(){
        for(Ability ability : getAbilities()){
            System.out.println("name: " + ability.getName() + "\n" + ability.getDescription());
        }
    }


    public void addExp(int exp) {
        int currentExperience = getExperience() + exp;
        if(currentExperience >= 100*getLevel()) {
            setExperience(getExperience() + exp - 100*getLevel());
            setLevel(getLevel() + 1);
            eventManager.notify("level up", this);
        } else {
            setExperience(currentExperience);
        }
    }

    public void levelUp() {
        System.out.println("You advanced from level + " + this.getLevel() + " to level " + this.getLevel() );
        System.out.println("Which attribute do you want to improve: ");
        System.out.println("1. Health.");
        System.out.println("2. Mana.");
        int choice = IOUtils.nextInt();
        switch (choice) {
            case 1:
                setHealth(getHealth() + 5);
                restore();
                break;
            case 2:
                setMana(getMana() + 5);
                restore();
        }
    }


    public void restore() {
        this.setCurrentMana(this.getMana());
        this.setCurrentHealth(this.getHealth());
    }


}
