package model.element;

import model.board.Content;
import model.fighter.Fighter;
import model.fighter.Hero;

public class Shield extends Item{
	
	public Shield(int value){
		super(value);
	}
	
	@Override
	public Content interact(Fighter hero){
		((Hero)hero).shieldify(getValue());
		return null;
	}
}