package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

public abstract class Enemy extends Fighter {
	
	protected double F;
	protected double S;
	
	public Enemy(double S, double F){
		this.F = F;
		this.S = S;
	}
	
	@Override
	public boolean canWalkOver() {
		return false;
	}
	
	@Override
	public Content interact(Fighter hero) {
		hero.injured( strength );
		if( hero.isAlive() ){
			hero.interact(this);
			if ( this.isAlive() )
				return null;
			else
			{
				((Hero)hero).addExperience(getLevel().getValue()); /** TODO: getLevel devuelve int **/
				return drop();
			}
		}
		else
			return null;
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
		return (int) Math.floor(((level.getValue() + 3)^2 - 10)*S);
	}
	
	@Override
	public int getStrength() {
		return (int) Math.floor(((level.getValue())^2 + 5*level.getValue())*0.5*F);
	}
	
	public abstract Content drop();	
	
}
