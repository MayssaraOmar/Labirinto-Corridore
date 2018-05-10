package model.element.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.Element;

public abstract class Entity implements Element {

	protected Point point;
	BufferedImage bufferedImage;

	public Entity(Point point, BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
		this.point = point;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(bufferedImage, point.x, point.y, null);
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
