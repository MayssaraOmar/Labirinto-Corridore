package model.tiles;

import java.awt.Point;

import model.ArmorGift;
import model.Bullet;
import model.BulletGift;
import model.Gift;
import model.HealthGift;
import model.ScoreGift;

public  class GiftsFactory {

	public Gift getGift(int type,Point p) {
		
		if(type == 3)
			return new HealthGift(p);
		else if (type == 4)
			return new ScoreGift(p);
		else if (type == 5)
			return new BulletGift(p);
		else if(type == 6)
		    return new ArmorGift(p);
		else
			return null;
	}
	
}
