package model.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.fighter.*;
import model.element.*;

public class GameLevelX extends Board {
	
	private List<Enemy> enemies;

	@Override
	protected void setContents() {
		for (int i=0; i < 6; i++){
			g[6][i].setContent(new Wall());
		}
		g[4][4].setContent(new Wall());
		g[5][4].setContent(new Wall());
		for (int i=0; i < 6; i++){
			g[i][7].setContent(new Wall());
		}
		g[10][0].setContent(new Wall());
		g[11][0].setContent(new Wall());
		for (int i=2; i < 9; i++){
			g[10][i].setContent(new Wall());
		}
		for (int i=4; i < 11; i++){
			g[i][9].setContent(new Wall());
		}
		g[5][10].setContent(new Wall());
		g[6][10].setContent(new Wall());
		g[5][11].setContent(new Wall());
		g[6][11].setContent(new Wall());
		
		g[4][1].setContent(new Goblin(1, this));
		g[3][5].setContent(new Goblin(1, this));
		g[5][6].setContent(new Goblin(2, this));
		g[7][3].setContent(new Goblin(2, this));
		g[11][4].setContent(new Goblin(3, this));
		g[1][3].setContent(new Snake(1));
		g[8][1].setContent(new Golem(2));
		g[8][5].setContent(new Golem(2));
		g[11][9].setContent(new Golem(3));
		g[0][11].setContent(new Golem(4));
		listEnemies();
		
		g[4][4].setContent(new Potion());
		g[11][6].setContent(new HealthBonus(5));
		g[11][7].setContent(new StrengthBonus(5));
		g[7][10].setContent(new Sword(10));
		g[7][11].setContent(new Shield(10));
	}

	private void listEnemies(){
		enemies = new ArrayList<Enemy>();
		for( Cell[] cellRow: g){
			for( Cell cell: cellRow){
				if( cell.getContent() instanceof Enemy ){
					enemies.add((Enemy)cell.getContent());
				}
			}
		}
	}

	@Override
	protected Point getHeroInitPosition() {
		return new Point(1, 1);
	}

	@Override
	public boolean gameOver() {
		if( !getHero().isAlive() )
			return true;
		for( Enemy enemy: enemies){
			if( enemy.isAlive() )
				return false;
		}
		return true;
	}

	@Override
	public boolean playerWon() {
		return getHero().isAlive();
	}
	
}
