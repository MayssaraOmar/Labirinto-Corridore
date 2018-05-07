package controller;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import view.Display;

public class Game implements Runnable {

	private final String title = "Maze Runner";
	private Thread thread;
	private boolean running;
	private final int width = 500;
	private final int height = 500;
	private Display display;

	// private final double width = ;
	public Game() {
		running = false;
		
	}

	public synchronized void start() { //synchronized is used whenever we directly work with threads 
		if (running) // to avoid problems if this method is called by accident when the game is already running 
			return;
		running = true; // the game will be running now that we're making a new thread
		thread = new Thread(this); // make a new thread which makes this part of the program (this class) runs separately from the rest of the program 
		thread.start(); // start starts the thread and calls the run method bellow
	}

	public synchronized void stop() { //synchronized is used whenever we directly work with threads 
		if (!running) // to avoid problems if this method is called by accident when the game has already stopped running 
			return;
		running = false; // the game won't be running now that we're stopping the current thread
		try {
			thread.join(); // stops the current thread safely 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	public void init() {
		display = new Display(title, width, height);
	}
	private void tick() { // updates everything for the game (logic)

	}

	private void render() { // render the graphics for the game, redraw the game screen  
		BufferStrategy bufferStrategy;
		Graphics g;
		bufferStrategy = display.getCanvas().getBufferStrategy(); // buffer strategy tells the computer how to draw to the screen and it uses buffers 
		if (bufferStrategy == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bufferStrategy.getDrawGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		bufferStrategy.show();
		g.dispose();
	}

	@Override
	public void run() {
		init();
		double target = 60.0;
		double nsPerTick = 1000000000.0 / target;
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		double unprocessed = 0.0;
		int fps = 0;
		int tps = 0;
		boolean canRender = false;

		while (running) {
			long now = System.nanoTime();
			unprocessed += (now - lastTime) / nsPerTick;
			lastTime = now;

			if (unprocessed >= 1.0) {
				tick();
				unprocessed--;
				tps++;
				canRender = true;
			} else {
				canRender = false;
			}
			
			
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			if (canRender) {
				render();
				fps++;
			}
			if (System.currentTimeMillis() - 1000 > timer) {
				timer += 1000;
				fps = 0;
				tps = 0;
			}
		}
		stop();
	}

	

}
