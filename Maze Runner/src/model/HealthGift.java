package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.entity.Info;

public class HealthGift extends Gift{


	
	public HealthGift() {
		super(Assets.gift_health);
		ID = 4;
				
	}
	
	public void doAction() {		
		Info.getInfo().setHealth(Info.getInfo().getHealth()+1);
		Info.getInfo().setScore(Info.getInfo().getScore()+20);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}


	
	
}