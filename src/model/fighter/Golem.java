package model.fighter;

import model.board.Content;
import model.element.Sword;

public class Golem extends Enemy{
        
        public final static double S = 1.35;
        public final static double F = 1;
        
        public Golem( int level ){
                super(S, F, level);
        }
        
        @Override
        public Content drop() {
                return new Sword(getLevel());
        }
}
