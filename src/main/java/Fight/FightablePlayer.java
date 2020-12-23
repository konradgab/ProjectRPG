package Fight;

public interface FightablePlayer extends Fightable {
    public float useAbility(int abilityNumber);
    public void getReward(int exp);
}
