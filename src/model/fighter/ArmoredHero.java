package model.fighter;

public class ArmoredHero extends Hero{
	
	private static final double SHIELD = 0.3;
	
	public ArmoredHero( Hero hero ){
		this.health = hero.health;
		this.strength = hero.strength;
		this.level = hero.level;
		this.sword = hero.sword; 
		this.experience = hero.experience;
	}
	
	@Override
	public void injured(int value){
		health -= Math.round(value * SHIELD);
	}
}
