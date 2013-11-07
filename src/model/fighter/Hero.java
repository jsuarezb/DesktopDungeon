package model.fighter;

import model.board.Content;
import model.fighter.level.Level;

public class Hero implements Fighter {

	protected Fighter fighter;
	
	public Hero(Fighter fighter){
		this.fighter = fighter;
	}
	
	protected Fighter getFighter(){
		return fighter;
	}
	
	@Override
	public void addExperience(int value){
		fighter.addExperience(value);
	}
	
	@Override
	public boolean canWalkOver() {
		return fighter.canWalkOver();
	}
	
	@Override
	public int getExperience() {
		return fighter.getExperience();
	}
	
	@Override
	public int getHealth() {
		return fighter.getHealth();
	}
	
	@Override
	public Level getLevel() {
		return fighter.getLevel();
	}
	
	@Override
	public int getMaxExperience() {
		return fighter.getMaxExperience();
	}
	
	@Override
	public int getMaxHealth() {
		return fighter.getMaxHealth();
	}
	
	@Override
	public int getStrength() {
		return fighter.getStrength();
	}
	
	@Override
	public boolean hasMaxLevel(){
        return fighter.hasMaxLevel();
	}
	
	@Override
	public void heal(int value) {
		fighter.heal(value);
	}
	
	@Override
	public void healFull() {
		fighter.healFull();
	}
	
	@Override
	public void injured(int value) {
		fighter.injured(value);
	}
	
	@Override
	public Content interact(Fighter enemy){
		enemy.injured( getStrength() );
		return this;
	}
	
	@Override
	public boolean isAlive() {
		return fighter.isAlive();
	}
	
	@Override
	public void stronger(int value) {
		fighter.stronger(value);
	}	
	
	@Override
	public int printStrength() {
		return fighter.printStrength();
	}
}
