package model.board;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import model.fighter.Fighter;
import model.fighter.Hero;
import model.fighter.HeroCharacter;
import model.fighter.HeroMovedListener;

public abstract class Board {
	
	public static final int SIZE = 12;
	
	protected Cell[][] g = new Cell[SIZE][SIZE];
	private Point heroPosition;
	private List<HeroMovedListener> listeners = new ArrayList<HeroMovedListener>();
	
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
		Fighter hero = new HeroCharacter(1);
		heroPosition = getHeroInitPosition();
		g[heroPosition.y][heroPosition.x].setContent(new Hero(hero));
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
					for( HeroMovedListener listener : listeners ){
						listener.heroMoved();
					}
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
						getHero().heal(getHero().getLevel().getValue());
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
	
	public abstract boolean gameOver();
	
	public abstract boolean playerWon();
	
	public void addHeroMovedListener( HeroMovedListener listener ){
		listeners.add(listener);
	}
}
