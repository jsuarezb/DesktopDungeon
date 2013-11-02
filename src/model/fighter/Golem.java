package model.fighter;

public class Golem extends Enemy{

	@Override
	public int getMaxHealth() {
		return (int) Math.floor(((level.getValue() + 3)^2 - 10)*1.35);
	}

}
