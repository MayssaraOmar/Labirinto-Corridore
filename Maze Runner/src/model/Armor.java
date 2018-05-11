package model;

import java.awt.Point;

import model.element.entity.Runner;

public class Armor extends Decorator{
	
	private Runner player;
	
		public Armor(Point p,Runner runner) {
			super( Assets.armor,5,5,p);
			player = runner;
		}
		
		public void doAction() {
			
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}

}
