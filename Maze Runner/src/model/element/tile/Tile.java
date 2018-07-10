package model.element.tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.element.Element;

public  class Tile extends Element{
	
	
	public static final int TILEWIDTH = 64, TILEHEIGHT = 64;
	private BufferedImage texture;
	
	public Tile(BufferedImage texture) {
		super();
		this.texture = texture;
	}
	
	public void tick() {
		
	}
	@Override
	public void render(Graphics g) {
		g.drawImage(texture, point.x, point.y, TILEWIDTH , TILEHEIGHT,  null);
		
	}

	public  boolean isSolid() {
		return true;
	}

	public boolean isDestroyable() {
		return false;
	}

}
