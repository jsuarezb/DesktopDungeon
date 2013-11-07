package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class StrengthBonus extends ValuableItem{  
	
	public StrengthBonus(int value){
		super(value);
	}
	
	@Override
	public Content interact(Fighter hero){
		hero.stronger(getValue());
		return hero;
	}
}
