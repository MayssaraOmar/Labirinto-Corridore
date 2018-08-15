package model.element.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import controller.ArmorOnPlayerState;
import controller.BulletObserver;
import controller.CareTaker;
import controller.DefaultPlayerState;
import controller.Game;
import controller.GameState;
import controller.HealthObserver;
import controller.Memento;
import controller.Observer;
import controller.PlayerState;
import controller.ScoreObserver;
import controller.Utils;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import model.Armor;
import model.ArmorGift;
import model.Animation;

import model.Assets;
import model.Bomb;
import model.Bullet;
import model.Checkpoint;
import model.Gift;
import model.HealthGift;
import model.Maze;

import model.element.Element;
import model.element.tile.Tile;




public class Runner extends Entity implements Observable {
	private Animation animRunLeft, animRunRight, animIdleRight, animIdleLeft, animDeadLeft, animDeadRight, animAttackLeft, animAttackRight;
	private static Runner uniqueRunner = null;
	// n7ot-ha tb3 state l health
	private int velocity;
	private int health;
	private int score;
	private int xMove, yMove, direction;
	private PlayerState playerState,defaultState;
	private int bullets;
	private CareTaker careTaker;
	private Bullet kinai;
	private Game game;
	private Observer healthObs,scoreObs,bulletObs;
	private boolean paused;
	private boolean die = false;
	

	
	// singleton DP
	public static Runner getRunner() {
		if (uniqueRunner == null)
			uniqueRunner = new Runner();
		return uniqueRunner;

	}

	protected Runner() {
		super();
		animRunLeft = new Animation(1000, Assets.runner_left_run);
		animRunRight = new Animation(1000, Assets.runner_right_run);
		animIdleLeft = new Animation(1000, Assets.runner_left_idle);
		animIdleRight = new Animation(1000, Assets.runner_right_idle);
		animDeadLeft = new Animation(1000, Assets.runner_left_dead);
		animDeadRight = new Animation(1000, Assets.runner_right_dead);
		animAttackLeft = new Animation(1000, Assets.runner_left_attack);
		animAttackRight = new Animation(1000, Assets.runner_right_attack);
		
		defaultState = new DefaultPlayerState();
		kinai = null;
		paused = false;
		playerState = defaultState;	
		ID = 3;
		bullets = 6;
		health = 3;
		velocity = 1;
		score = 0;
		width = 50;
		height = 50;
		xMove = 0;
		yMove = 0;
		direction = 2;
		careTaker = new CareTaker();
		bulletObs = new BulletObserver();
		scoreObs = new ScoreObserver();
		healthObs = new HealthObserver();
		
	//	RunnerImg = l mfrood n-get l image mn l spritesheet ely hn7mlha mn l game
		
	}		
	public void changeState(PlayerState state) {
		playerState = state;
		
	}
	
	public void move() {
		Element collided ;
		boolean moved = false;
		if( (collided = checkEntityCollisions(xMove, 0)) == null) {
				moveX();
				
		}else {
			if(collided instanceof Gift || collided instanceof Bomb) {
				
				((Entity) collided).doAction();	
				
					removeElement(collided);
			}else if(collided instanceof Checkpoint) {
				System.out.println("checked");
				((Entity) collided).doAction();
				careTaker.saveCheckpoint();
				
				removeElement(collided);
			}else if(collided instanceof Prize) {
			//	score =+ ((1/(int)game.getMyTimer().getSec())*240); 
				game.gameWon();
			}
			
			scoreObs.update(score);
			healthObs.update(health);
			bulletObs.update(bullets);
		}
		if((collided = checkEntityCollisions(0, yMove)) == null) {
			moveY();
		}else {
			if(collided instanceof Gift || collided instanceof Bomb) {
				((Entity) collided).doAction();				
					removeElement(collided);
					
			}/*else if(collided instanceof ArmorGift) {
					
					removeElement(collided);
			}	*/
			else if(collided instanceof Prize) {
			//	score =+ ((1/(int)game.getMyTimer().getSec())*240); 
				game.gameWon();
			}else if(collided instanceof Checkpoint) {
				((Entity) collided).doAction();
				careTaker.saveCheckpoint();				
				removeElement(collided);
			}
			scoreObs.update(score);
			healthObs.update(health);
			bulletObs.update(bullets);
			
		}
		if(health == 0) {
			dead();
		}
		
	}

	public void moveX() {
		Point p = Utils.toGrid(point.x, point.y);
		p.x += xMove;
		setPoint(Utils.toIso(p.x, p.y));
	}

	public void moveY() {
		// point.y += yMove;
		Point p = Utils.toGrid(point.x, point.y);
		p.y += yMove;
		setPoint(Utils.toIso(p.x, p.y));
	}

	
	/*private boolean collisionWithTile(int x,int y) {
		
		//return maze.getTile(x, y).isSolid();
	}*/
	
	public void addGame(Game game) {
		this.game= game;
	}
	
	public Game getGame() {
		return game;
	}
	
	public void tick() {
		
		animRunLeft.tick();
		animRunRight.tick();
		animIdleRight.tick();
		animIdleLeft.tick();
		
		getMove();
		move();
		if(kinai != null) {
			kinai.tick();
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(getCurrentAnimationFrame(), point.x, point.y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		
		if(playerState.getClass().toString().contains("ArmorOnPlayerState")) {System.out.println("hi");
			g.drawImage(Assets.shield_left, point.x, point.y, Tile.TILEWIDTH, Tile.TILEHEIGHT, null);
		}
		

	}

	private BufferedImage getCurrentAnimationFrame() {
		if(die==true) {
			return animDeadRight.getCurrentFrame();
		}
		if (xMove < 0)
			return animRunLeft.getCurrentFrame();
		if (xMove > 0)
			return animRunRight.getCurrentFrame();
		if (yMove < 0)
			return animRunRight.getCurrentFrame();
		if (yMove > 0)
			return animRunLeft.getCurrentFrame();
		if(direction==3 || direction == 1)
		return animIdleLeft.getCurrentFrame();
		else 	return animIdleRight.getCurrentFrame();

	}

	// getInput Move
	public void getMove() {
		
		xMove = 0;
		yMove = 0;
		
		if (Game.getKeyManager().up) {
			xMove -= velocity;
			direction = 1;
		
		}

		else if (Game.getKeyManager().down) {
			xMove += velocity;
			direction = 2;
			
		}

		else if (Game.getKeyManager().left) {
			yMove += velocity;
			direction = 3;
			
		}

		else if (Game.getKeyManager().right) {
			yMove -= velocity;
			direction = 4;
		
		}else if(Game.getKeyManager().fire) {
			
			if(bullets >0 && direction != 0) {
				bullets --;
			kinai = new Bullet(point, direction);
			kinai.fire();
			GameState.elements.add(kinai);			
			}else {
				kinai = null;
			}
			
		}
	}
	
	public void dead() {
		setHealth(0);
		if(careTaker.getHistory().size() == 0) {
			die=true;			
			game.gameOver();
			
		}else {
			Memento current = null;			
			current = Runner.getRunner().getCareTaker().restoreCheckpoint();
				setBullets(current.getBullets());
				setHealth(current.getHealth());
				setScore(current.getScore());
				setPoint(current.getPosition());
				tick();
				
		}
	}

	public int getVelocity() {
		return velocity;
	}

	public void setVelocity(int velocity) {
		this.velocity = velocity;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
				
		this.score += score;
	}

	public int getBullets() {
		return bullets;
	}

	public void setBullets(int bullets) {
		this.bullets = bullets;
	}

	public PlayerState getPlayerState() {
		return playerState;
	}

	public void setPlayerState(PlayerState playerState) {
		this.playerState = playerState;
	}


	public boolean isPaused() {
		return paused;
	}

	public void setPaused(boolean paused) {
		this.paused = paused;
		if(paused) {
			velocity = 0;			
		}else {
			velocity = 1;
		}
		
	}

	
	
	public CareTaker getCareTaker() {
		return careTaker;
	}

	public void setCareTaker(CareTaker careTaker) {
		this.careTaker = careTaker;
	}

	
	
	@Override
	public void addListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeListener(InvalidationListener arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void notifyObservers() {
		
	}
	
	}
