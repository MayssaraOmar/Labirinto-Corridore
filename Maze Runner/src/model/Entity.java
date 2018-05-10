package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

public abstract class Entity {

	protected Point pt;
	protected BufferedImage entityImg;
	
	public Entity(Point p,BufferedImage img) {
		entityImg = img;
		pt = p;
	}
	

	public void render(Graphics g) {		
		 g.drawImage(entityImg,pt.x,pt.y,null);
	}
	
	public void tick() {
		
	}

	public Point getPoint() {		
		return pt;
	}	
		
	public void doAction() {	
		
	}
	
}
