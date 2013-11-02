package model.fighter;

import model.board.Content;
import model.element.Sword;

public class Golem extends Enemy{

	public Golem(double s, double f) {
		super(s, f);
	}
	
	@Override
	public Content drop() {
		return new Sword(getLevel().getValue());
	}
}

