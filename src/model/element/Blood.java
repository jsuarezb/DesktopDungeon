package model.element;

import model.board.Content;
import model.fighter.Fighter;

public class Blood implements Content{

	@Override
	public boolean canWalkOver() {
		return true;
	}

	@Override
	public Content interact(Fighter hero) {
		return hero;
	}
	
}
