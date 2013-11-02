package view;

import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import model.board.Cell;
import model.board.Content;
import model.element.Blood;
import model.element.HealthBonus;
import model.element.Potion;
import model.element.Shield;
import model.element.StrengthBonus;
import model.element.Sword;
import model.element.Wall;
import model.fighter.ArmoredHero;
import model.fighter.Fighter;
import model.fighter.Goblin;
import model.fighter.Golem;
import model.fighter.Hero;
import model.fighter.Snake;

public class ImageManager {
	
	private Map<String, Image> images = new HashMap<String, Image>();
	
	public ImageManager() {
		initImages();
	}

	public void initImages() {
		try{
			images.put(ArmoredHero.class.getName(), ImageUtils.loadImage("resources/heroArmor.png"));
			images.put(Hero.class.getName(), ImageUtils.loadImage("resources/heroBase.png"));
			images.put(Cell.class.getName(), ImageUtils.loadImage("resources/floor.png"));
			images.put(Blood.class.getName(), ImageUtils.loadImage("resources/blood.png"));
			images.put(Shield.class.getName(), ImageUtils.loadImage("resources/armor.png"));
			images.put(StrengthBonus.class.getName(), ImageUtils.loadImage("resources/attackbonus.png"));
			images.put(Goblin.class.getName(), ImageUtils.loadImage("resources/goblin.png"));
			images.put(Golem.class.getName(), ImageUtils.loadImage("resources/golem.png"));
			images.put(HealthBonus.class.getName(), ImageUtils.loadImage("resources/healthbonus.png"));
			images.put(Potion.class.getName(), ImageUtils.loadImage("resources/healthPotion.png"));
			images.put(Snake.class.getName(), ImageUtils.loadImage("resources/Serpent.png"));
			images.put(Sword.class.getName(), ImageUtils.loadImage("resources/sword.png"));
			images.put(Wall.class.getName(), ImageUtils.loadImage("resources/wall.png"));
			images.put(ArmoredHero.class.getName(), ImageUtils.loadImage("resources/heroArmor.png"));
			images.put("FOG", ImageUtils.loadImage("resources/fog.png"));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Image get(Cell cell) {
		if (cell.hasContent()) {
			Content content = cell.getContent();
		if (content instanceof Fighter) {
				Fighter fighter = (Fighter) content;
				Image image = ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(fighter.getClass().getName()));
				
				Color color;
				switch( fighter.getLevel() ){
				case 1:
					color = new Color( 0, 255, 0 );
					break;
				case 2:
					color = new Color( 64, 255, 0 );
					break;
				case 3:
					color = new Color( 128, 255, 0 );
					break;
				case 4:
					color = new Color( 191, 255, 0 );
					break;
				case 5:
					color = new Color( 255, 255, 0 );
					break;
				case 6:
					color = new Color( 255, 255, 0 );
					break;
				case 7:
					color = new Color( 255, 191, 0 );
					break;
				case 8:
					color = new Color( 255, 128, 0 );
					break;
				case 9:
					color = new Color( 255, 64, 0 );
					break;
				case 10:
					color = new Color( 255, 0, 0 );
					break;
				default:
					color = new Color( 0, 255, 0 );
				}
				
				return ImageUtils.drawString(image, String.valueOf(fighter.getLevel()), color);
			} else {
				return ImageUtils.overlap(images.get(cell.getClass().getName()), images.get(cell.getContent().getClass().getName()));
			}
		} else {
			return images.get(cell.getClass().getName());
		}
		
	}
	
	public Image get(String key) {
		return images.get(key);
	}
}
