package controller;

import model.element.entity.Runner;

public class DefaultPlayerState extends PlayerState{

	public DefaultPlayerState(Runner player) {
		super(player);
		}

	@Override
	public void hitBomb() {
		player.setHealth(player.getHealth()-1);
		
	}

	
}
