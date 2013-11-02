package model.fighter;

import model.board.Content;
import model.element.Blood;

public class Snake extends Enemy{
        
        public final static double S = 1;
        public final static double F = 1;
        
        public Snake(int level){
                super(S, F, level);
        }
        
        @Override
        public Content drop() {
                return new Blood();
        }

}
