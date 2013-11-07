package model.fighter;

public class ArmoredHero extends Hero{
	
	private static final double SHIELD = 0.7;
	
	public ArmoredHero(Fighter hero){
		super(hero);
	}
	
	@Override
	public void injured(int value) {
		fighter.injured((int)(SHIELD*value));
	}

}

