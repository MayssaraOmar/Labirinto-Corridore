package model.element;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import controller.GameState;
import model.Maze;

public abstract class Element {
	
	protected Point point;
	protected Rectangle bounds;
	protected int width=64,height=64;
	public Element() {
		bounds = new Rectangle(0, 0, width, height);

	}

	public abstract void tick();
	public abstract void render (Graphics g);
	
	public abstract Point getPoint();
	public abstract void setPoint(Point point);
	
	public boolean checkEntityCollisions(int xOffset, int yOffset) {
		Point p = Maze.toGrid(point.x, point.y);

		Rectangle b1 = new Rectangle(p.x+xOffset, p.y+yOffset, 1, 1);

		for(Element e : GameState.elements) {
			if(e.equals(this))
				continue;
			Point p2 = Maze.toGrid(e.getPoint().x, e.getPoint().y);

			Rectangle b2 = new Rectangle(p2.x, p2.y, 1, 1);
			if(b2.intersects(b1)) {
				System.out.println(e.getPoint().x+"    "+ e.getPoint().y);
				return true;
			}
				
		}
		return false;

		
	}
	/*public Rectangle getCollisionBounds(float xOffset, float yOffset) {
		Point p = Maze.toGrid(point.x, point.y);
		
		return new Rectangle((int)(p.x + bounds.x + xOffset) ,(int)(p.y+bounds.y+yOffset),width,height);
		
	}*/
}
