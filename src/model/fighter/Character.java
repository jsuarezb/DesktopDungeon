package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

public class Character implements Fighter{

	protected int health;
	protected int experience;
	private int bonusStrength;  
	protected Level level;
	
	public void initialize(){
		health = getMaxHealth();
	}
	
	@Override
	public boolean isAlive(){
		return health > 0;
	}
	
	@Override
	public void injured(int value){
		health -= value;
		
		if (health < 0) 
			health = 0;
	}
	
	@Override
	public void heal(int value){
		health += value;
		if( health >= getMaxHealth() ){
			health = getMaxHealth();
		}
	}
	
	@Override
	public void healFull(){
		health = getMaxHealth();
	}

	@Override
	public int getStrength(){
		return level.getStrength() + bonusStrength;
	}
	
	@Override
	public void stronger(int value){
		bonusStrength += value;
	}
	
	@Override
	public int getHealth(){		
		return health;
	}
	
	@Override
	public int getMaxHealth(){
		return level.getMaxHealth();
	}
	
	@Override
	public Level getLevel(){
		return level;
	}
	
	@Override
	public boolean hasMaxLevel(){
		return getLevel().getValue() == getMaxLevel();
	}
	
	public int getMaxLevel(){
		return level.getMaxLevel();
	}
	
	@Override
	public void addExperience(int value){
		experience += value;
		if( getExperience() >= getMaxExperience() && !hasMaxLevel() ){
            level.levelUp();
            experience = 0;
            bonusStrength = 0;
            this.healFull();
    }
	}
	
	@Override
	public int getExperience(){
		return experience;
	}

	@Override
	public int getMaxExperience(){
		return level.getMaxExperience();
	}

	@Override
	public boolean canWalkOver() {
		return false;
	}

	@Override
	public Content interact(Fighter hero){
		return this;
	}
	
	public int printStrength(){
		return getStrength();
	}
}
