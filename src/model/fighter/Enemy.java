package model.fighter;

import model.board.Content;

public abstract class Enemy extends Fighter {
	
	protected double F;
	protected double S;
	
	public Enemy(double S, double F, int level){
		super( level );
		this.F = F;
		this.S = S;
	}
	
	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		hero.injured(getMaxStrength());
		if( hero.isAlive() ){
			hero.interact(this);
			if ( this.isAlive() )
				return null;
			else
			{
				((Hero)hero).addExperience(getLevel()); 
				return drop();
			}
		}
		else
			return null; //GAME OVER
	}
	
	public boolean hasMaxLevel() {
		return true;
	}
	
	@Override
	public int getMaxHealth() {
		return (int) Math.floor(((getLevel() + 3)^2 - 10)*S);
	}
	
	public int getMaxStrength() {
		return (int) Math.floor((getLevel()^2 + 5*getLevel())*0.5*F);
	}
	
	public abstract Content drop();	
}
