package model;

import java.awt.image.BufferedImage;
import model.element.tile.TilesSpriteSheet;

public class Assets {

	private static final int width = 112, height = 129;
	public static BufferedImage  stone, tree, path, bomb_0,bomb_1, gift_score, gift_health, shield_left, shield_right, kunai;

	public static BufferedImage[] runner_left_run, runner_right_run, runner_left_idle, runner_right_idle;

	public static void init() {

		TilesSpriteSheet tilesSpriteSheet = new TilesSpriteSheet(ImageLoader.loadImage("/alltiles_sheet.png"));
		stone = tilesSpriteSheet.crop(0 * width, 4 * height, width, height);
		tree = tilesSpriteSheet.crop(1 * width, 14 * height, width, height);
		// path = tilesSpriteSheet.crop(3 * width, 0 * height, width, height);
		path = tilesSpriteSheet.crop(6 * width, 13 * height, width, height);
		bomb_0= tilesSpriteSheet.crop(8 * width, 14 * height, width, height);
		bomb_1= tilesSpriteSheet.crop(5 * width, 11 * height, width, height);
		gift_health= tilesSpriteSheet.crop(7 * width, 13 * height, width, height);
		gift_score= tilesSpriteSheet.crop(4 * width, 3 * height, width, height);
		shield_left = ImageLoader.loadImage("/shield/left.png");
		kunai = ImageLoader.loadImage("/kunai.png");
		// runner animations

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
