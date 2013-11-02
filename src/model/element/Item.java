package model.element;

public abstract class Item implements Valuable {

	private int value;
	
	public Item(int value){
		this.value = value;
	}
	
	@Override
	public boolean canWalkOver() {
		return true;
	}
	
	@Override
	public int getValue() {
		return value;
	}
}
