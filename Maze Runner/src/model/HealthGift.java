package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class HealthGift extends Gift{


	
	public HealthGift(Point p) {
		super(p,Assets.heart);
		
				
	}
	
	public void doAction() {		
		player.setHealth(player.getHealth()+1);		
	}

	
	
}