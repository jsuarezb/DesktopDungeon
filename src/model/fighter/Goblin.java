package model.fighter;

import model.board.Content;
import model.element.Blood;
package model.fighter;

import model.board.Content;
import model.element.Blood;

public class Goblin extends Enemy{
	
	private final static double S = 1;
	private final static double F = 0.7;
	
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
