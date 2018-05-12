package model;

import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import model.element.tile.TilesSpriteSheet;

public class Assets {

	// private static final int width = 72, height = 72;
	private static final int width = 112, height = 128;
	public static BufferedImage runner, stone, tree, path, gift, bomb, armor, gun, bullet, heart, money;

	public static BufferedImage[] runner_left_run, runner_right_run, runner_left_idle, runner_right_idle;

	public static void init() {
		/*
		 * TilesSpriteSheet tilesSpriteSheet = new
		 * TilesSpriteSheet(ImageLoader.loadImage("/tiles_spritesheet.png")); stone =
		 * tilesSpriteSheet.crop(1*width, 4*height, width+3, height); tree =
		 * tilesSpriteSheet.crop(11*width+3,11*height+3 + height/2, 50, height); path =
		 * tilesSpriteSheet.crop(8*width+3, 11*height+3, width, height);
		 */

		TilesSpriteSheet tilesSpriteSheet = new TilesSpriteSheet(ImageLoader.loadImage("/alltiles_sheet.png"));
		stone = tilesSpriteSheet.crop(0 * width, 4 * height + 4, width, height);

		tree = tilesSpriteSheet.crop(width, 11 * height, width, height);
		path = tilesSpriteSheet.crop(3 * width, 0 * height, width, height);
		runner = tilesSpriteSheet.crop(3 * width, 1 * height, width, height);

		runner_left_run = new BufferedImage[10];
		runner_right_run = new BufferedImage[10];
		runner_left_idle = new BufferedImage[10];
		runner_right_idle = new BufferedImage[10];
		// runner_run[0]= ImageLoader.loadImage("/runner/run/Run__00"+i+".png");
		// runner_run[0]= ImageLoader.loadImage("/runner/run/Run__000.png");

		for (int i = 0; i < 10; i++) {
			runner_left_run[i] = ImageLoader.loadImage("/runner/left/run/Run__00" + i + ".png");
			runner_right_run[i] = ImageLoader.loadImage("/runner/right/run/Run__00" + i + ".png");
			runner_left_idle[i] = ImageLoader.loadImage("/runner/left/idle/Idle__00" + i + ".png");
			runner_right_idle[i] = ImageLoader.loadImage("/runner/right/idle/Idle__00" + i + ".png");
		}
	}

}
