package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import controller.GameState;
import model.element.entity.Entity;
import model.element.entity.Runner;
import model.element.tile.Tile;

public class Armor extends Decorator {

	private Entity entity;	
	private BufferedImage image;
	
	public Armor(Runner runner) {
		super();		
		entity = runner;
		point = entity.getPoint();	
		image = Assets.shield_left;
		GameState.elements.add(this);
		}

		@Override
		public void render(Graphics g) {
			/*g.drawImage(image, point.x, point.y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
			System.out.println("shi "+point.x+" "+ point.y);
			if(((Runner) entity).move()) {
				entity.render(g);
			}*/			
		}
		@Override
		public void tick( ) {
				super.tick();
		}
		
		

}