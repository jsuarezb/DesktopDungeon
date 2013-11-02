package model.element;

public abstract class Item extends Content{
	
	@Override
	public boolean canWalkOver() {
		return true;
	}
}
