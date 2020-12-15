package Player;

import Fight.Fightable;

public class PlayerWarrior extends Player implements Fightable {

    public PlayerWarrior() {
        super();
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


}
