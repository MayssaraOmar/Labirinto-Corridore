package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class HealthGift extends Gift{


	
	public HealthGift() {
		super(Assets.heart);
		
				
	}
	
	public void doAction() {		
		player.setHealth(player.getHealth()+1);		
	}

	
	
}