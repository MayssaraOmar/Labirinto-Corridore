package model;

import java.awt.Graphics;
import java.awt.Point;

public interface Element {
	
	
	public abstract void tick();
	public abstract void render (Graphics g);
	
	public Point getPoint();
	public void setPoint(Point point);




	
	
}
