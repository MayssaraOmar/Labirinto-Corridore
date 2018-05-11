package model;

import java.awt.Point;

import model.element.entity.Runner;

public class Armor extends Decorator{
	
	private Runner player;
	
		public Armor(Point p) {
			super( Assets.armor,5,5,p);
			player = Runner.getRunner(null);
		}
		
		public void doAction() {
			
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}

}
