package model.fighter;

import model.board.Content;
import model.element.Sword;

public class Golem extends Enemy{

	private final static double S = 1.35;
	private final static double F = 1;
	
	@Override
	public Content drop() {
		return new Sword(getLevel().getValue());
	}

	public double getF() {
		return F;
	}

	public double getS() {
		return S;
	}
}
