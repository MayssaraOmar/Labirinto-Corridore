package controller;

import model.Armor;
import model.Bomb;
import model.DeathBomb;
import model.DefaultBomb;
import model.element.entity.Runner;

public class ArmorOnPlayerState extends PlayerState{	
	
	
	public ArmorOnPlayerState(Runner player) {
		super(player);
		player.changeState(this);
		
		player = new Armor(player);
	}

	
	
	public void hitBomb(Bomb bomb) {
		
		if(bomb instanceof DefaultBomb) {
		//shil l armor
			player.changeState(new DefaultPlayerState(player));
			
		}
		else if(bomb instanceof DeathBomb) {
			player.setHealth(0);
		}
	}

}