package model.fighter;

import model.fighter.level.HeroLevel;

public class HeroCharacter extends Character {  

	private final static int MAXLEVEL = 10; 
	
	public HeroCharacter( int value ){
		this.level = new HeroLevel( value, MAXLEVEL );
		initialize();
	}
}
