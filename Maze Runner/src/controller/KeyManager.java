package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {
	private boolean[] keys; // Boolean value is one with two choices: true or false, yes or no, 1 or 0
	public boolean up, down, left, right, fire;

	public KeyManager() {
		keys = new boolean[256];

	}

	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		fire = keys[KeyEvent.VK_SPACE];
	}

	@Override
	public void keyPressed(KeyEvent e) {

		// TODO Auto-generated method stub
		keys[e.getKeyCode()] = true ;
		System.out.println("presses");
		}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	@Override
	public void keyTyped(KeyEvent arg0) {

	}

}
