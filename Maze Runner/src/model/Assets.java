package model;

import java.awt.image.BufferedImage;

import model.tiles.TilesSpriteSheet;

public class Assets {
	
	private static final int width = 72, height = 72; 
	public static BufferedImage runner, stone, tree, path, gift, bomb, armor, gun, bullet;
	public static void init() {
		TilesSpriteSheet tilesSpriteSheet = new TilesSpriteSheet(ImageLoader.loadImage("/tiles_spritesheet.png"));
		stone = tilesSpriteSheet.crop(1*width, 4*height, width, height);
		tree = tilesSpriteSheet.crop(11*width,11*height + height/2, 50, height);
		path = tilesSpriteSheet.crop(8*width, 11*height, width, height);
	}

}
