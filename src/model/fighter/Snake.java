package model.fighter;

import model.board.Content;
import model.element.Blood;

public class Snake extends Enemy{

	public Snake(double s, double f) {
		super(s, f);
	}
	
	@Override
	public Content drop() {
		return new Blood();
	}
}

