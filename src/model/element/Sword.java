package model.element;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.Hero;

public class Sword extends ValuableItem{
	
	public Sword(int value){
		super(value);
	}
	
	@Override
	public Content interact(Fighter hero){
		((Hero)hero).swordify(getValue());
		
		return hero;
	}
}
