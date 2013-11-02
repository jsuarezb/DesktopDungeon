package model.fighter;

import model.board.Content;
import model.element.Blood;

/* TODO: FALTA LISTENER */

public class Goblin extends Enemy{
        
        public final static double S = 1;
        public final static double F = 0.7;
        
        public Goblin( int level ){
                super(S, F, level);
        }
        
        @Override
        public Content drop() {
                return new Blood();
        }

}
