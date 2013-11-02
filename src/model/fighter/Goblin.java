package model.fighter;

import model.board.Content;
import model.element.Blood;
package model.fighter;

import model.board.Content;
import model.element.Blood;

public class Goblin extends Enemy{
	
	public final static double S = 1;
	public final static double F = 0.7;
	
	public Goblin(){
		super(S, F);
	}
	
	@Override
	public Content drop() {
		return new Blood();
	}

}
