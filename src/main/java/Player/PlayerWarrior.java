package Player;

import Fight.Fightable;

public class PlayerWarrior extends Player implements Fightable {

    public PlayerWarrior() {
        super();
    }

    public PlayerWarrior(PlayerWarrior target) {
        super(target);
    }

    @Override
    public Player clone() {
        return new PlayerWarrior(this);
    }

    @Override
    public float takeDamage(float damage) {
        return 0;
    }


    @Override
    public int getMainAttribute() {
        return 0;
    }

    @Override
    public float basicAttack() {
        return 0;
    }

    @Override
    public void levelUp() {
        System.out.println("You advanced from level + " + (this.getLevel() - 1) + " to level " + this.getLevel());
        System.out.println("You gain 3 mana and 12 health points.");
        setHealth(getHealth() + 12);
        setMana(getMana() + 3);
        restore();
    }



}
