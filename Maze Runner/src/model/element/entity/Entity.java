package model.element.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.Element;
import model.element.tile.Tile;

public abstract class Entity extends Element {

	//protected Point point;
	BufferedImage bufferedImage;
	//protected Rectangle bounds;
	//protected int width=64,height=64;

	public Entity(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
		//mmkn n7dd width w height l kol entity seperately
		//bounds = new Rectangle(0, 0, width, height);
	}
	
	@Override
	public void render(Graphics g) {
							
		
			g.drawImage(bufferedImage, point.x, point.y,Tile.TILEWIDTH,Tile.TILEHEIGHT, null);	
				
		
		g.setColor(Color.BLUE);
		g.fillRect(point.x , point.y  , width, height);
		
	}
	@Override
	public Point getPoint() {
		return point;
	}
	@Override
	public void setPoint(Point point) {
		this.point = point;
		
	}
	

	public void doAction() {	
		
	}

}
