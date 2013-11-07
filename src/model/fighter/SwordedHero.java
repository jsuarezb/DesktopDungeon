package model.fighter;

import model.board.Content;
import model.element.Sword;

public class SwordedHero extends Hero{ /**Acumula las espadas.*/ 

	private Sword sword;
	
	public SwordedHero(Fighter hero, Sword sword){
		super(hero);
		this.sword = sword;
		
	}
	
	@Override
	public Content interact(Fighter enemy){ 
		enemy.injured( getStrength() + sword.getValue() );
		return this;
	}
	
	public int printStrength(){
		return sword.getValue() + getStrength();
	}
}
