package model.fighter;

public class Snake extends Enemy{

	@Override
	public int getMaxHealth() {
		return (int) Math.floor((level.getValue() + 3)^2 - 10);
	}
	
}
