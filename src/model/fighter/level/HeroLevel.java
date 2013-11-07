package model.fighter.level;

public class HeroLevel extends Level {
	
	public HeroLevel(int value, int maxLevel) {
		super( value, maxLevel );
	}
	
	@Override
	public int getMaxHealth() {
		return (int) 10*getValue();
	}

	@Override
	public int getStrength() {
		return (int) 5*getValue();
	}

	@Override
	public int getMaxExperience() {
		return 5*getValue();
	}

}
