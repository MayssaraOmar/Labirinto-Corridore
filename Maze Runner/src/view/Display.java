package view;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Display {

	private JFrame frame;
	private String title;
	private int width, height;
	private Canvas canvas;
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame(title);
		frame.setSize(500, 500);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		canvas = new Canvas();
		// to make sure that the canvas will always be the same size 
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		frame.add(canvas);
		frame.pack();
	
	}
	public Canvas getCanvas() {
		return canvas;
	}

}
