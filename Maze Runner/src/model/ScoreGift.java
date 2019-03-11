
package model;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;

import model.element.entity.Info;

public class ScoreGift extends Gift{

	

 	public ScoreGift() {
 		super(Assets.gift_score);
 		ID  = 7;		
 	}
 	
 	public void doAction() {		
 		Info.getInfo().setScore(Info.getInfo().getScore()+10);
 		
 	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
