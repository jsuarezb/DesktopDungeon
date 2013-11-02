package model.fighter;

public class ArmoredHero extends Hero{
	
	private static final double SHIELD = 0.3;
	
	@Override
	public void injured(int value){
		health -= Math.round(value*SHIELD);
	}
}
