package Player;

import Fight.Fightable;

public class PlayerMage extends Player implements Fightable {

    public PlayerMage() {
        super();
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
    public boolean fight(Fightable player) {
        return true;
    }

    @Override
    public int getMainAttribute() {
        return (int) this.getMana();
    }


}
