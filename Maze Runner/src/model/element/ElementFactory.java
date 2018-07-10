package model.element;

import model.ArmorGift;
import model.Armor;
import model.BulletGift;
import model.Checkpoint;
import model.DeathBomb;
import model.DefaultBomb;
import model.HealthGift;
import model.ScoreGift;
import model.element.entity.Runner;
import model.element.tile.PathTile;
import model.element.tile.StoneTile;
import model.element.tile.TreeTile;

public class ElementFactory {

	public static Element getElement(int type) {

		if (type == 0)
			return new PathTile();
		else if (type == 1)
			return new StoneTile();
		else if (type == 2)
			return new TreeTile();
		else if (type == 3)
			return Runner.getRunner();
		else if (type == 4) 
			return new HealthGift();
		else if (type == 5)		
			return new BulletGift();			
		else if (type == 6)
			return new ArmorGift();
		else if (type == 7)
			return new ScoreGift();
		else if (type == 8)
			return new DefaultBomb();
		else if (type == 9)
			return new DeathBomb();		
		else if (type == 10)
			return new Checkpoint();	
		return new PathTile(); // default tile

	}

}
