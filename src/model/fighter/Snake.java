package model.fighter;

import model.board.Content;
import model.element.Blood;

public class Snake extends Enemy{

	private final static double S = 1;
	private final static double F = 1;
	
	@Override
	public Content drop() {
		return new Blood();
	}

	public double getF() {
		return F;
	}

	public double getS() {
		return S;
	}

}
