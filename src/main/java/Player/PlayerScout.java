package Player;

import Fight.Fightable;

public class PlayerScout extends Player implements Fightable {

    public PlayerScout() {
        super();
    }


    @Override
    public float takeDamage(float damage) {
        return 0;
    }

    @Override
    public int getMainAttribute() {
        return (int)(  0.5 * this.getMana() + 0.5 * this.getHealth() );
    }

    @Override
    public float basicAttack() {
        return 0;
    }


}
