package model.fighter;

import model.board.Content;
import model.fighter.level.HeroLevel;
import model.fighter.level.Level;

public class Hero extends Fighter {

	private int sword;
	private int shield;
	
	public Hero() {
		level = new HeroLevel(1, 10);
	}
	
	public void addExperience(int value) {
		
	}
	
	@Override
	public boolean canWalkOver() {
		return true;
	}


	public int getExperience() {
		return 0;
	}
	
	@Override
	public Level getLevel() {
		return level;
	}


	public int getMaxExperience() {
		return 0;
	}
	
	@Override
	public Content interact(Fighter hero) {
		return this;
	}
	
	public boolean hasMaxLevel(){
		return false;
	}
	
	public int getMaxHealth(){
		return getLevel().getValue() * 10;
	}
	
	public void stronger(int value){
                strength += value;
        }
	
	public void swordify(int value){
		sword = value;
	}
	
	public void shieldify(int value){
		shield = value;
	}
}
