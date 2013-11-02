package model.element;

import model.board.Content;
import model.fighter.ArmoredHero;
import model.fighter.Fighter;

public class Shield extends ValuableItem{
	
	public Shield(int value){
		super(value);
	}
	
	@Override
	public Content interact(Fighter hero){
		ArmoredHero armoredHero = (ArmoredHero)hero;
		return armoredHero;
	}
}
