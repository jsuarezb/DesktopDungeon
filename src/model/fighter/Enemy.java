package model.fighter;

import model.board.Content;
import model.fighter.level.EnemyLevel;

public abstract class Enemy extends Character {
	
	public Enemy( int level, double S, double F ){
		this.level = new EnemyLevel( level, level, S, F );
		initialize();
	}
	
	@Override
	public Content interact(Fighter hero) {
		hero.injured( this.getStrength() );
		if( hero.isAlive() ){
				hero.interact(this);
			
			if (!this.isAlive()){
				hero.addExperience(getLevel().getValue()); 
				return drop();
			}
		}
		return this;
	}
	
	public abstract Content drop();
}