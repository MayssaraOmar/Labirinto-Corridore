package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class Gift extends Entity{
	
		protected Player player;
		
		public Gift(Point p, BufferedImage img) {
			super(p, img);
			player = Player.getPlayer();
			
		}
}
