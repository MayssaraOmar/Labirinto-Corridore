package model;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import model.element.tile.TilesSpriteSheet;

public class Assets {
	
	private static final int width = 72, height = 72; 
	//private static final int width = 112, height = 128; 
	//private static final int width = 25, height = 25; 
	public static BufferedImage runner, stone, tree, path, gift, bomb, armor, gun, bullet,heart,money;
	public static void init() {
		TilesSpriteSheet tilesSpriteSheet = new TilesSpriteSheet(ImageLoader.loadImage("/tiles_spritesheet.png"));
		stone = tilesSpriteSheet.crop(1*width, 4*height, width, height);
		tree = tilesSpriteSheet.crop(11*width,11*height + height/2, 50, height);
		path = tilesSpriteSheet.crop(8*width, 11*height, width, height);
		
		
		/*
		TilesSpriteSheet tilesSpriteSheet = new TilesSpriteSheet(ImageLoader.loadImage("/alltiles_sheet.png"));
		stone = tilesSpriteSheet.crop(0*width, 4*height+4, width, height);
		
		tree = tilesSpriteSheet.crop(width,11*height, width, height);
		path = tilesSpriteSheet.crop(3*width, 0*height, width, height);
		runner = tilesSpriteSheet.crop(3*width, 1*height, width, height);*/
	}

}
