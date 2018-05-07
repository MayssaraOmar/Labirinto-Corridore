package view;

import java.awt.EventQueue;

import controller.Game;

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
