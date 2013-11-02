package model.fighter;

import model.board.Content;

public abstract class Fighter implements Content {
	
	protected int health;
	protected int strength;
	protected int level;

	public Fighter(){
	}
	
	public void initialize( int level ){
		this.level = level;
		health = getMaxHealth();
		strength = getMaxStrength();
	}
	
	public boolean isAlive(){
		return health > 0;
	}
	
	public void injured(int value){
		health -= value;
	}
	
	public void heal(int value){
		health += value;
		if( health >= getMaxHealth() ){
			health = getMaxHealth();
		}
	}
	
	public void healFull(){
		health = getMaxHealth();
	}

	public int getStrength(){
		return strength;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getLevel(){
		return level;
	}
	
	public abstract boolean hasMaxLevel();
	
	public abstract int getMaxHealth();
	
	public abstract int getMaxStrength();
	
}
