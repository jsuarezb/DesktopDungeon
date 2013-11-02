package model.element;

import model.board.Content;

public abstract class Item implements Content{
	        
	@Override
	public boolean canWalkOver() {
		return true;
	}
}
