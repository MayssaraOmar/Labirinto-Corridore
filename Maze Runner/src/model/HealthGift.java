package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class HealthGift extends Gift{


	
	public HealthGift() {
		super(Assets.gift_health);
		ID = 4;
				
	}
	
	public void doAction() {		
		player.setHealth(player.getHealth()+1);
		player.setScore(player.getScore()+20);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}


	
	
}