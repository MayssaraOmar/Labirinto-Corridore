package model;

import java.awt.Graphics;

import com.sun.media.jfxmedia.events.PlayerStateEvent.PlayerState;

import controller.ArmorOnPlayerState;
import controller.GameState;
import model.element.entity.Runner;

public class ArmorGift extends Gift{
	
	private ArmorOnPlayerState playerState;
	
		public ArmorGift() {
			super(Assets.shield_left);
			ID = 6;
		}
		
		public void doAction(){
			player =  new Armor(player);	
		//	new ArmorOnPlayerState(player);
				System.out.println("done");
				Runner.getRunner().setPlayerState(new ArmorOnPlayerState());
		}

		@Override
		public void tick() {
			// TODO Auto-generated method stub
			
		}

}
