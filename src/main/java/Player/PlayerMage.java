package Player;

import Fight.Fightable;

public class PlayerMage extends Player implements Fightable {

    public PlayerMage() {
        super();
    }

    public PlayerMage(PlayerMage target) {
        super(target);
    }

    @Override
    public Player clone() {
        return new PlayerMage(this);
    }


    @Override
    public float takeDamage(float damage) {
        setCurrentHealth((float) (getCurrentHealth() - ((1 / (0.1 * getArmor())) * damage)));
        return (float) ((1 / (0.1 * getArmor())) * damage);
    }

    @Override
    public float basicAttack() {
        return this.getCurrentMana() * 0.2f;
    }

    @Override
    public int getMainAttribute() {
        return (int) this.getMana();
    }

    @Override
    public void levelUp() {
        System.out.println("You advanced from level + " + (this.getLevel() - 1) + " to level " + this.getLevel());
        System.out.println("You gain 10 mana and 5 health points.");
        setHealth(getHealth() + 5);
        setMana(getMana() + 10);
        restore();
    }


}
