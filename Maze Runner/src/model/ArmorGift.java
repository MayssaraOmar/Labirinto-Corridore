package model;

import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;

import controller.ArmorOnPlayerState;
import controller.GameState;

public class ArmorGift extends Gift{
	
	private ArmorOnPlayerState playerState;
	
		public ArmorGift() {
			super( Assets.armor);
			playerState = new ArmorOnPlayerState(player);
		}
		
		public void doAction() {
			player = new Armor(player);
			
		}

}
