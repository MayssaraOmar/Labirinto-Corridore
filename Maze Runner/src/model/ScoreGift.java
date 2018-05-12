
package model;

import java.awt.Point;
import java.awt.image.BufferedImage;

public class ScoreGift extends Gift{

	

 	public ScoreGift() {
 		super(Assets.money);
 						
 	}
 	
 	public void doAction() {		
 		player.setScore(player.getScore()+1);		
 	}
	
}
