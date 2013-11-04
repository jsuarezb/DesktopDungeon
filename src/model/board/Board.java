package model.board;

import java.awt.Point;

import model.fighter.Enemy;
import model.fighter.Hero;

public abstract class Board {
	
	public static final int SIZE = 12;
	
	protected Cell[][] g = new Cell[SIZE][SIZE];
	private Point heroPosition;
	
	public Board() {
		initialize();
	}
	

	public void initialize() {
		for (int x = 0; x < SIZE; x++) {
			for (int y = 0; y < SIZE; y++) {
				g[y][x] = new Cell();
			}
		}
		setContents();
		heroPosition = getHeroInitPosition();
		g[heroPosition.y][heroPosition.x].setContent(new Hero());
		cleanFog(heroPosition);
	}	

	public void heroMove(Move move) {
		if (getHero().isAlive()) {
			Point newPosition = new Point(heroPosition.x + move.getX(), heroPosition.y + move.getY());
	
			if (newPosition.x >= 0 && newPosition.y >= 0 && newPosition.x < SIZE && newPosition.y < SIZE) {
				if (g[newPosition.y][newPosition.x].canWalkOver()) {
					g[newPosition.y][newPosition.x].onWalk(getHero());
					g[heroPosition.y][heroPosition.x].removeContent();
					heroPosition = newPosition;
					cleanFog(heroPosition);
				} else if (g[newPosition.y][newPosition.x].canInteract()) {
					g[newPosition.y][newPosition.x].interact(getHero());
				}
			}
		}
	}
	
	private void cleanFog(Point p){
		for (int i = p.y-1; i <= p.y+1; i++) {
			for (int j = p.x-1; j <= p.x+1 ; j++) {
				if (i>=0 && i<SIZE && j>=0 && j<SIZE) {
					if (g[i][j].hasFog()) {
						g[i][j].removeFog();
						getHero().heal(getHero().getLevel());
					}
				}
			}
		}
	}
	
	
	public Point getHeroPosition(){
		return heroPosition;
	}
	
	public Cell get(int x, int y) {
		return g[y][x];
	}
	
	public Hero getHero() {
		return (Hero) g[heroPosition.y][heroPosition.x].getContent();
	}

	protected Cell[][] g(){
		return g;
	}
	
	protected abstract void setContents();

	protected abstract Point getHeroInitPosition();
	
	public boolean gameOver() {
		if (getHero().isAlive()){
			for (Cell[] row : g){
				for (Cell cell : row){
					if (cell.getContent() instanceof Enemy)
						return false;
				}
			}
		}
		
		return true;
	}
	
	public boolean playerWon() {
		return getHero().isAlive();
	}
}
