package model.fighter;

import model.board.Content;

public class Hero extends Fighter {

	private int sword;
	private int experience;
	private static final int MAXLEVEL = 10;
	
	public Hero(){
		this(1);
	}
	
	public Hero( int level ){
		super( level );
	}
	
	public void addExperience(int value) {
		experience += value;
		if( getExperience() >= getMaxExperience() && hasMaxLevel() ){
			levelUp();
			experience = 0;
			strength = getMaxStrength();
			this.healFull();
		}
	}
	
	@Override
	public boolean canWalkOver() {
		return true;
	}


	public int getExperience() {
		return experience;
	}
	
	@Override
	public int getLevel() {
		return level;
	}

	public int getMaxExperience() {
		return getLevel()*5;
	}
	
	@Override
	public Content interact(Fighter enemy) {
		enemy.injured( getStrength() + sword );
		return null;
	}
	
	public boolean hasMaxLevel(){
		return getLevel() != getMaxLevel();
	}
	
	private int getMaxLevel() {
		return MAXLEVEL;
	}
	
	private void levelUp() {
		level++;
	}

	public int getMaxHealth(){
		return getLevel()*10;
	}
	
	@Override
	public int getMaxStrength() {
		return 5*getLevel();
	}
	
	public void stronger(int value){
                strength += value;
        }
	
	public void swordify(int value){
		sword = value;
	}
	
}
