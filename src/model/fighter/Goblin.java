package model.fighter;

import model.board.Content;
import model.element.Blood;

public class Goblin extends Enemy{
	
	public Goblin(double s, double f) {
		super(s, f);
	}
	
	@Override
	public Content drop() {
		return new Blood();
	}
}

