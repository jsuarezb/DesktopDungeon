package model.board;

import java.awt.Point;

public class GameLevelX extends Board {

	public GameLevelX(){
		
	}

	@Override
	protected void setContents() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected Point getHeroInitPosition() {
		return new Point(1, 1);
	}

	@Override
	public boolean gameOver() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean playerWon() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
