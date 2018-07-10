package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import controller.Game;
import controller.Utils;
import model.element.Element;
import model.element.entity.Entity;
import model.element.tile.Tile;

public class Bullet extends Entity{

	private int  vBullet;
	private BufferedImage image;
	private int direction,xMove,yMove;
	
	public Bullet(Point p, int direction) {
		super();
		
		this.point = p;
	/*	this.point.x +=50;
		this.point.y +=50;
		*/image = Assets.kunai;
		this.direction = direction;
		vBullet = 1;	
	}
	
	public void doAction() {
		
	}
	

public void tick() {
	/*point.x += 5;
	point.y +=5;*/
	System.out.println("hi");
		fire();
		move();

	}
	
	public void fire() {
		xMove = 0;
		yMove = 0;
		
		if (direction == 1 )
		{
			xMove -= vBullet;
		}else if (direction == 2 ) {
			xMove += vBullet;
		}else if (direction == 3) {
			yMove += vBullet;
		}else if (direction == 4) {
			yMove -= vBullet;
		}
	
	}
	
	public void move() {
		Element collided ;
		if( (collided = checkEntityCollisions(xMove, 0)) == null) {
				moveX();	
		}else {
			removeElement(this);	
			if(collided.isDestroyable())
				removeElement(collided);
			
			
		}
		if((collided = checkEntityCollisions(0, yMove)) == null) {
			moveY();
		}else {
			removeElement(this);	
			if(collided.isDestroyable())
				removeElement(collided);					
		}	
	
	}

	public void moveX() {
		
		Point p = Utils.toGrid(point.x, point.y);
		p.x += xMove;
		setPoint(Utils.toIso(p.x, p.y));
	}

	public void moveY() {
		// point.y += yMove;
		Point p = Utils.toGrid(point.x, point.y);
		p.y += yMove;
		setPoint(Utils.toIso(p.x, p.y));
	}

	@Override
	public void render(Graphics g) {
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGg");
		System.out.println(point.x + "   "+point.y+ " " + direction);
		g.drawImage(image, point.x, point.y, 20,20, null);
		System.out.println(point.x + "   "+point.y+ " " + direction);

		
	}


}