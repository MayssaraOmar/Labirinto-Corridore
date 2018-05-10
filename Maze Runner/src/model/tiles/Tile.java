package model.tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.Assets;

public  class Tile {
	
	
	
	public static final int TILEWIDTH = 25, TILEHEIGHT = 25;
	private BufferedImage texture;
	
	public Tile(BufferedImage texture) {
		System.out.println("Const");
		this.texture = texture;
		System.out.println("texture  "+this.texture);
		
	}
	
	public void tick() {
		
	}
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH , TILEHEIGHT,  null);
		//g.drawImage(Assets.stone, x, y, null);
	}
	

	public  boolean isSolid() {
		return true;
	}

}
