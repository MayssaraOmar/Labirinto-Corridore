package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.entity.Entity;
import model.element.entity.Runner;

public class Gift extends Entity{
	
		protected Runner player;
		
		public Gift(Point p, BufferedImage img) {
			super(img,10,10, p);
			player = Runner.getRunner(null);
			
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}
}
