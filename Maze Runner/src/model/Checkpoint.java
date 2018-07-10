package model;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.element.entity.Entity;
import model.element.entity.Runner;
import model.element.tile.Tile;

public class Checkpoint extends Entity{

	protected BufferedImage image;	
	
		public  Checkpoint()  {			
			image = Assets.checkpoint;
			ID  = 10;
		}

	@Override
	public void render(Graphics g) {
		g.drawImage(image, point.x, point.y, Tile.TILEWIDTH , Tile.TILEHEIGHT,  null);
		
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
}
