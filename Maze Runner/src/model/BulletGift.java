package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.tile.Tile;

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
		g.drawImage(image, point.x, point.y, 32 ,32,  null);		
		
	}

	@Override
	public void tick() {
		
		// TODO Auto-generated method stub
		
	}
	
	
	
}