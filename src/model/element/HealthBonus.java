package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class HealthBonus extends Item{
	
	public HealthBonus(int value){
		super(value);
	}
	
	@Override
	public Content interact(Fighter hero){
		hero.heal(getValue());
		return null;
	}
}
