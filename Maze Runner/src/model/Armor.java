package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.entity.Entity;
import model.element.entity.Runner;

public class Armor extends Decorator {


	private Entity entity;
	
	
	public Armor(Runner runner) {
		super(Assets.armor);
		entity = runner;
		point = entity.getPoint();
	}

		
		

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}
}