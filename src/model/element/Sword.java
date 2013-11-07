package model.element;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.Hero;
import model.fighter.SwordedHero;

public class Sword extends ValuableItem{
	
	public Sword(int value){
		super(value);
	}
	
	@Override
	public Content interact(Fighter hero){
		Hero swordedHero = new SwordedHero(hero, this);
		return swordedHero;
	}
}
