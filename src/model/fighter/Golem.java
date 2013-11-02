package model.fighter;

import model.board.Content;
import model.element.Sword;

public class Golem extends Enemy{
	
	public final static double S = 1.35;
	public final static double F = 1;
	
	public Golem(){
		super(S, F);
	}
	
	@Override
	public Content drop() {
		return new Sword(getLevel().getValue());
	}

}
