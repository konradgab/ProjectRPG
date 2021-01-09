package Player;

import Abilities.Ability;
import EventManager.PlayerEventManager;
import Field.Field;
import Field.IField;
import Fight.Fightable;
import Fight.FightablePlayer;
import Utils.IOUtils;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter

public abstract class Player implements FightablePlayer {
    PlayerEventManager eventManager = new PlayerEventManager("travel");
    String name;
    private int level;
    private float health;
    private float mana;
    private int experience;
    private int armor;
    private float currentHealth;
    private float currentMana;
    IField currentField;
    List<Ability> abilities;

    public Player() {
        this.level = 0;
        this.health = 0;
        this.mana = 0;
        this.experience = 0;
        this.armor = 0;
        this.currentHealth = 0;
        this.currentMana = 0;
    }

    public Player(String name) {
        this.name = name;
        this.level = 0;
        this.health = 0;
        this.mana = 0;
        this.experience = 0;
        this.armor = 0;
        this.currentHealth = 0;
        this.currentMana = 0;
    }

    public Player(Player target) {
        if (target != null) {
            this.eventManager = target.getEventManager();
            this.name = target.name;
            this.level = target.level;
            this.health = target.health;
            this.mana = target.mana;
            this.experience = target.experience;
            this.armor = target.armor;
            this.currentHealth = target.currentHealth;
            this.currentMana = target.currentMana;
            this.currentField = target.currentField;
            this.abilities = target.abilities;
        }
    }

    public int move() {
        System.out.println("Would you like to go to the next or previous location?");
        System.out.println("1. Next.");
        System.out.println("2. Previous.");
        return IOUtils.nextInt();
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

    public void printAbilities() {
        for (Ability ability : getAbilities()) {
            System.out.println("name: " + ability.getName() + "\n" + ability.getDescription());
        }
    }

    public abstract Player clone();


    @Override
    public void getReward(int exp) {
        int currentExperience = getExperience() + exp;
        if (currentExperience >= 100 * getLevel()) {
            setExperience(getExperience() + exp - 100 * getLevel());
            setLevel(getLevel() + 1);
            levelUp();
        } else {
            setExperience(currentExperience);
        }
    }

    abstract void levelUp();

    public void restore() {
        this.setCurrentMana(this.getMana());
        this.setCurrentHealth(this.getHealth());
    }

    public float useAbility(int abilityNumber) {
        this.setCurrentMana((float) (this.getCurrentMana() - this.getAbilities().get(abilityNumber).getCost()));
        return this.getAbilities().get(abilityNumber).use(this.getMainAttribute());
    }


}
