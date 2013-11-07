package model.fighter.level;

public class EnemyLevel extends Level {

	private double S;
	private double F;
	
	public EnemyLevel( int value, int maxLevel, double S, double F ){
		super( value, maxLevel );
		this.S = S;
		this.F = F;
	}
	
	@Override
	public int getMaxHealth() {
		return (int) Math.floor((Math.pow((getValue() + 3), 2) - 10)*S);
	}

	@Override
	public int getStrength() {
		return (int) Math.floor((Math.pow(getValue(), 2) + 5*getValue())*0.5*F);
	}

	@Override
	public int getMaxExperience() {
		return 0;
	}

}
