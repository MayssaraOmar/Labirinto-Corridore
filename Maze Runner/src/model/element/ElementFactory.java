package model.element;

import java.awt.Point;

import model.Armor;
import model.BulletGift;
import model.HealthGift;
import model.ScoreGift;
import model.element.entity.Runner;
import model.element.tile.PathTile;
import model.element.tile.StoneTile;
import model.element.tile.TreeTile;

public class ElementFactory {

	public static Element getElement(int type,Point p) {

		if (type == 0)
			return new PathTile(p);
		else if (type == 1)
			return new StoneTile(p);
		else if (type == 2)
			return new TreeTile(p);
		else if (type == 3)
			return Runner.getRunner(p);
		else if(type == 4)
			return new HealthGift(p);
		else if(type == 5)
			return new BulletGift(p);
		else if(type == 6)
			return new Armor(p);
		else if(type == 5)
			return new ScoreGift(p);
		
		return new PathTile(p); // default tile

	}

}
