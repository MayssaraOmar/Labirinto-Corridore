package controller;

import model.Bomb;
import model.DefaultBomb;
import model.element.entity.Runner;

public class DefaultPlayerState extends PlayerState{
		
	public DefaultPlayerState(Runner player) {
		super(player);
		player.changeState(this);
		}

	public void hitBomb(Bomb bomb) {
		
		if(bomb instanceof DefaultBomb)
			player.setHealth(player.getHealth()-1);
		else
			player.setHealth(0);
	}

	
}
