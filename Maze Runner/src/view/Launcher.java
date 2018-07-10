package view;

import java.awt.EventQueue;

import javax.lang.model.element.Element;

import controller.Game;
import model.Gift;
import model.HealthGift;
import model.element.entity.Entity;

public class Launcher {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game game = new Game();
					
					game.start();
										
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
