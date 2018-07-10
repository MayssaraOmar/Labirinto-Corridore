package view;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;

public class Display {

	private JFrame frame;
	private String title;
	private int width, height;
	private Canvas canvas;
	/**
	 * @wbp.nonvisual location=63,174
	 */
	private final JLabel label = new JLabel("New label");
	private InfoPanel panel;
	
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
		label.setIcon(new ImageIcon(Display.class.getResource("/runner/run/Run__000.png")));
		frame = new JFrame(title);
		frame.setSize(2160, 2160);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		panel = InfoPanel.getPanel();
		panel.addFrame(this);
		
		panel.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		canvas = new Canvas();
		// to make sure that the canvas will always be the same size 
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);
		frame.getContentPane().add(panel);
		frame.getContentPane().add(canvas);
		frame.pack();
	
	}
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() { // to acess jframe outside display class
		
		return frame ;
	}

}
