package model.element.tile;

import java.awt.image.BufferedImage;

public class TilesSpriteSheet {
	private BufferedImage sheet;
	
	public TilesSpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y, int width, int height) {
		return sheet.getSubimage(x, y, width, height);
		
	}
	
}
