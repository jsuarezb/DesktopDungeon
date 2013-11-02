package model.fighter;

public class Goblin extends Enemy{
	
	@Override
	public int getMaxHealth() {
		return (int) Math.floor((level.getValue() + 3)^2 - 10);
	}
	
	@Override
	public int getStrength() {
		return (int) Math.floor(((level.getValue())^2 + 5*level.getValue())*0.5*0.7);
	}

}
