package model.fighter;

import model.board.Board;
import model.board.Content;
import model.element.Blood;

public class Goblin extends Enemy implements HeroMovedListener{
        
        private final static double S = 1;
        private final static double F = 0.7;
        private final static int HEAL = 1;
        private int steps;
        
        public Goblin( int level, Board board ){
        	super( level, S, F );
        	board.addHeroMovedListener(this);
        }
        
        @Override
        public Content drop() {
                return new Blood();
        }
        
        public void heroMoved(){
        	if( steps % 2 == 0 && isAlive() )
        		this.heal(HEAL);
        	steps++;
        }

}
