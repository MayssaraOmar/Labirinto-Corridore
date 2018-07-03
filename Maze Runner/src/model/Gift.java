package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.entity.Entity;
import model.element.entity.Runner;
import model.element.tile.Tile;

public abstract class Gift extends Entity{
	protected Runner player;
	protected BufferedImage image;	
	
		public Gift(BufferedImage img) {			
			super();
			player = Runner.getRunner();
			image = img;
			
		}
		
		@Override
		public void render(Graphics g) {
			g.drawImage(image, point.x, point.y, Tile.TILEWIDTH , Tile.TILEHEIGHT,  null);
			
		}
		
		public boolean isDestroyable() {
			return true;
		}
	
	
}
