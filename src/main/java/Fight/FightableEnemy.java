package Fight;

public interface FightableEnemy extends Fightable{
    public boolean fight (Fightable player, FightManager fightManager);
}
