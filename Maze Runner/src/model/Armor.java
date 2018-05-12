package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

import controller.GameState;
import model.element.entity.Entity;
import model.element.entity.Runner;

public class Armor extends Decorator {

	private Entity entity;	
	
	public Armor(Runner runner) {
		super();		
		entity = runner;
		point = entity.getPoint();
		GameState.elements.add(this);
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}
}