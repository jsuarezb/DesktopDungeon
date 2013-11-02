package model.fighter;

import model.board.Content;
import model.fighter.level.HeroLevel;
import model.fighter.level.Level;

public class Hero extends Fighter {

	private int sword;
	private int experience;
	
	public Hero() {
		level = new HeroLevel(1, 10);
	}
	
	public void addExperience(int value) {
		experience += value;
		if( getExperience() >= getMaxExperience() && hasMaxLevel() ){
			getLevel().levelUp();
			experience = 0;
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
	public Level getLevel() {
		return level;
	}

	public int getMaxExperience() {
		return getLevel().getValue()*5;
	}
	
	@Override
	public Content interact(Fighter enemy) {
		enemy.injured( getStrength() + sword );
		return null;
	}
	
	public boolean hasMaxLevel(){
		return getLevel().getValue() != getLevel().getMaxLevel();
	}
	
	public int getMaxHealth(){
		return getLevel().getValue()*10;
	}
	
	public void stronger(int value){
                strength += value;
        }
	
	public void swordify(int value){
		sword = value;
	}
}
