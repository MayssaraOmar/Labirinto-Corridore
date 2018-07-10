package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public class BulletGift extends Gift{

	public BulletGift() {
		super(Assets.kunai );
		ID = 5;
	}

	public void doAction() {
		player.setBullets(player.getBullets()+1);
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void tick() {
		
		// TODO Auto-generated method stub
		
	}
	
	
	
}