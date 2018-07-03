package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.DefaultPlayerState;
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
import javax.swing.ImageIcon;

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
	private final JLabel lblHealth = new JLabel("health");
	private final JLabel lblScore = new JLabel("score");
	private final JLabel lblKunai = new JLabel("Kunai");

	public static InfoPanel getPanel() {
		if (uniquePanel == null) {
			uniquePanel = new InfoPanel();
		}
		return uniquePanel;
	}

	private InfoPanel() {
		super();

		initGUI();
	}
	private void initGUI() {
		setLayout(null);
		setBounds(0, 0, 447, 258);
		setBackground(Color.PINK);
		time.setBounds(24, 21, 160, 28);
		time.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(time);
		
		

		score.setBounds(24, 112, 84, 25);
		score.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(score);
		
				health.setBounds(24, 159, 84, 28);
		health.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(health);
		
		ActionListener a = new myActionListener();
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(316, 21, 102, 28);
		btnSave.addActionListener(a);
		
				kunai.setBounds(24, 62, 74, 31);
		kunai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(kunai);
		btnSave.setActionCommand("save");
		btnSave.setFocusable(false);
		add(btnSave);
		
		btnLoad.setBounds(316, 62, 102, 28);
		btnLoad.addActionListener(a);
		btnLoad.setActionCommand("load");
		btnLoad.setFocusable(false);
		add(btnLoad);
		
		btnNewGame.setBounds(316, 100, 102, 37);
		btnNewGame.addActionListener(a);
		btnNewGame.setActionCommand("newGame");
		add(btnNewGame);
		
		label.setBounds(176, 30, 116, 215);		
		add(label);
		
		btnPause.setBounds(316, 191, 102, 28);
		btnPause.addActionListener(a);
		btnPause.setActionCommand("pause");
		btnPause.setFocusable(false);
		add(btnPause);
		
		btnResume.setBounds(316, 150, 102, 28);
		btnResume.addActionListener(a);
		btnResume.setActionCommand("resume");
		btnResume.setFocusable(false);
		add(btnResume);
		lblHealth.setBounds(110, 157, 74, 30);
		
		add(lblHealth);
		lblScore.setBounds(110, 110, 84, 27);
		
		add(lblScore);
		lblKunai.setBounds(110, 77, 56, 16);
		
		add(lblKunai);
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
				
			}else if(e.getActionCommand().equals("load")) {	
				
				GameState.uniqueGameState.load("load.txt");
			}else if(e.getActionCommand().equals("newGame")) {				
				Runner.getRunner().setPlayerState(new DefaultPlayerState()); 
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