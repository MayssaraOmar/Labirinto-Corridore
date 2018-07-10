package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Game;
import controller.GameState;
import controller.Observable;
import controller.Observer;
import model.SaveAndLoad;
import model.element.entity.Runner;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InfoPanel extends JPanel {

	private JLabel time = new JLabel();
	private JLabel health = new JLabel();
	private JLabel score = new JLabel();
	private JLabel kunai = new JLabel();
	private Game game;

	private static InfoPanel uniquePanel = null;
	private final JButton btnLoad = new JButton("Load");
	private final JButton btnNewGame = new JButton("New Game");
	private JLabel label = new JLabel();
	private Display screen ; 
	private final JButton btnPause = new JButton("Pause");
	private final JButton btnResume = new JButton("Resume");

	public static InfoPanel getPanel() {
		if (uniquePanel == null) {
			uniquePanel = new InfoPanel();
		}
		return uniquePanel;
	}

	private InfoPanel() {
		super();
		setLayout(null);
		setBounds(0, 0, 575, 438);
		setBackground(Color.PINK);
		time.setBounds(24, 21, 142, 51);
		time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(time);
		
		

		score.setBounds(303, 21, 79, 51);
		score.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(score);

		health.setBounds(287, 184, 124, 76);
		health.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(health);

		kunai.setBounds(48, 191, 118, 51);
		kunai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(kunai);
		
		ActionListener a = new myActionListener();
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(494, 31, 68, 51);
		btnSave.addActionListener(a);
		btnSave.setActionCommand("save");
		btnSave.setFocusable(false);
		add(btnSave);
		
		btnLoad.setBounds(494, 131, 68, 51);
		btnLoad.addActionListener(a);
		btnLoad.setActionCommand("load");
		btnLoad.setFocusable(false);
		add(btnLoad);
		
		btnNewGame.setBounds(473, 205, 89, 37);
		btnNewGame.addActionListener(a);
		btnNewGame.setActionCommand("newGame");
		add(btnNewGame);
		
		label.setBounds(51, 292, 418, 135);		
		add(label);
		
		btnPause.setBounds(473, 324, 89, 23);
		btnPause.addActionListener(a);
		btnPause.setActionCommand("pause");
		btnPause.setFocusable(false);
		add(btnPause);
		
		btnResume.setBounds(473, 379, 89, 23);
		btnResume.addActionListener(a);
		btnResume.setActionCommand("resume");
		btnResume.setFocusable(false);
		add(btnResume);

	}

	public void setTime(String time) {
		this.time.setText(time);
	}

	public void setScore(Integer score) {
		this.score.setText(score.toString());
	}

	public void setHealth(Integer health) {
		this.health.setText(health.toString());
	}

	public void setBullets(Integer bullets) {
		this.kunai.setText(bullets.toString());
	}
	
	public void setGameEnd(String text) {
		label.setText(text);
	}
	
	public void addGame(Game game) {
		this.game = game;
	}
	public void addFrame(Display screen) {
		this.screen = screen;
	}
	

	private class myActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getActionCommand().equals("save")) {				
				SaveAndLoad.saveFile("load.txt");	
				//System.out.println("save");
				
			}else if(e.getActionCommand().equals("load")) {	
				
				GameState.uniqueGameState.load("load.txt");
			}else if(e.getActionCommand().equals("newGame")) {				
				screen.getFrame().dispose();	
				game.setMyTimer((long) 0);
				new Game().start();
				//SaveAndLoad.saveFile("maze.txt");				
			}else if(e.getActionCommand().equals("pause")) {
				Runner.getRunner().setPaused(true);
				game.setPaused(true);
				
			}else if(e.getActionCommand().equals("resume")) {
				Runner.getRunner().setPaused(false);
				game.setPaused(false);				
			}
			
		}
	
	
		}

	
	}