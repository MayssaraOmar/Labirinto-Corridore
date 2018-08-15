package model.element.entity;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Assets;
import model.element.tile.Tile;

public class Prize extends Entity{

	private static Prize uniquePrize = null;
	
	private BufferedImage img;
	
	private Prize() {
		img = Assets.prize;
		
	}
	
	public static Prize getPrize() {
		if(uniquePrize == null)
			uniquePrize = new Prize();
		return uniquePrize;
		
	}



	@Override
	public void render(Graphics g) {
		g.drawImage(img, point.x, point.y, Tile.TILEWIDTH , Tile.TILEHEIGHT,  null);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}
	
}
