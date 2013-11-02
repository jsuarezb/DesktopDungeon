package model.fighter;

import model.board.Content;
import model.element.blood;
import model.fighter.level.Level;

public abstract class Enemy extends Fighter {

	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero) {
		if (!this.isAlive()){
			return new Blood;
		}
		return null;
	}

	@Override
	public abstract int getMaxHealth();

	@Override
	public Level getLevel() {
		return level;
	}
	
	@Override
	public int getStrength() {
		return (int) Math.floor(((level.getValue())^2 + 5*level.getValue())*0.5);
	}
	
}
