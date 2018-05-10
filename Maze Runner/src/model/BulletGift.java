package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class BulletGift extends Gift{

	public BulletGift(Point p) {
		super(p, Assets.bullet);
	}

	public void doAction() {
		player.getBullets().add(1);
	}
	
}
