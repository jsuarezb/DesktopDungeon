package model.element;

public abstract class ValuableItem extends Item implements Valuable {

	private int value;
	
	public ValuableItem(int value){
		this.value = value;
	}
	
	@Override
	public int getValue() {
		return value;
	}
}
