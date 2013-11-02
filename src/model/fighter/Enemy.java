package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

public abstract class Enemy extends Fighter {
	
	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.injured( strength );
		if( hero.isAlive() ){
			this.injured( hero.getStrength() );
			if ( this.isAlive() ){
				return null;
			}
			else
			{
				return drop();
				((Hero)hero).addExperience(getLevel().getValue()); /** TODO: getLevel devuelve int **/
			}
		}
		else
			return new GameOver();
	}

	@Override
	public Level getLevel() { /** TODO: getLevel devuelve int **/
		return level; 
	}
	
	public boolean hasMaxLevel() {
		return true;
	}
	
	@Override
	public int getMaxHealth() {
		return (int) Math.floor(((level.getValue() + 3)^2 - 10)*getS());
	}
	
	@Override
	public int getStrength() {
		return (int) Math.floor(((level.getValue())^2 + 5*level.getValue())*0.5*getF());
	}
	
	public abstract Content drop();	
	
	public abstract double getS();	
	
	public abstract double getF();	
}
