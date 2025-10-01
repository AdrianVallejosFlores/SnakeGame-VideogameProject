package Drivers;

import Objects.*;
import Interfaces.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase GameEngine es responsable de gestionar la lógica del juego, incluyendo
 * el manejo de entidades del juego, la detección de colisiones, el puntaje y el estado general del juego.
 * Coordina las interacciones entre la Serpiente, las entidades del juego y el entorno del juego.
 */
public class GameEngine implements ActionListener {

	private List<Entity> entityList;
	private Snake snake;
	private SnakeGame snakeGame;
	private CollisionsManager collisionManager;
	private PositionManager positionManager;
	private ScoreManager scoreManager; 
	private LifeManager lifeManager;
	private LevelManager levelManager;

	private Timer timer;
	private final int DELAY = 90;
	private boolean inGame = true;
	
	public GameEngine(SnakeGame snakeGame, ScoreManager scoreManager) {
		this.snakeGame = snakeGame;
		this.scoreManager = scoreManager;
		this.lifeManager = new LifeManager();
		this.positionManager = new PositionManager();
		this.collisionManager = new CollisionsManager(snakeGame, this);
		this.levelManager = new LevelManager(scoreManager, this);
		this.snake = new Snake(5);
		this.entityList = new ArrayList<Entity>();
	}
	
	public void addEntityApple () {
		this.entityList.add(new Apple(snakeGame.getWidth(), snakeGame.getHeight(), this.positionManager));
	}
	
	public void addEntityOrange () {
		this.entityList.add(new Orange(snakeGame.getWidth(), snakeGame.getHeight(), this.positionManager));
	}
	
	public void addEntityBlackHole () {
		this.entityList.add(new BlackHole(snakeGame.getWidth(), snakeGame.getHeight(), this.positionManager));
	}
	
	public void removeEntityBlackHole () {
		for (int i = 0; i < this.entityList.size(); i++) {
			if (this.entityList.get(i) instanceof BlackHole) {
				this.entityList.remove(this.entityList.get(i));
				i = this.entityList.size();
			}
		}
	}

	public void removeEntityOrange () {
		for (int i = 0; i < this.entityList.size(); i++) {
			if (this.entityList.get(i) instanceof Orange) {
				this.entityList.remove(this.entityList.get(i));
				i = this.entityList.size();
			}
		}
	}
	
	public void removeEntityApple () {
		for (int i = 0; i < this.entityList.size(); i++) {
			if (this.entityList.get(i) instanceof Apple) {
				this.entityList.remove(this.entityList.get(i));
				i = this.entityList.size();
			}
		}
	}
	
	public void startGame() {
		addPositionActuals();
		timer = new Timer(DELAY, this);
		timer.start();
	}
	
	public void endGame() {
		this.inGame = false;
	    timer.stop();
	    if (SwingUtilities.getWindowAncestor(snakeGame) != null) {
	        SwingUtilities.getWindowAncestor(snakeGame).dispose();
	    }
	    new Menu(this.scoreManager).setVisible(true);
	}
	
	public void addPositionActuals() {
		positionManager.clearPositions();
		positionManager.addPosition(this.snake.getSnakePosX(0) + 100, this.snake.getSnakePosY(0) + 100, this.snake.getSnakeRectSize());
		positionManager.addPosition(this.snake.getSnakePosX(0) - 100, this.snake.getSnakePosY(0) - 100, this.snake.getSnakeRectSize());
		for (Entity entity: this.entityList) {
			positionManager.addPosition(entity.getX(), entity.getY(), entity.getSize());
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(inGame) {
			snake.move();
			addPositionActuals();
			collisionManager.checkCollisionLimits();
			collisionManager.checkCollisionBody(); 
			collisionManager.checkCollisionEntity();
			levelManager.reviewLevels(this.scoreManager.getScore());
			snakeGame.repaint();
		}else {
			endGame();
		}		
	}
	
	public void removePositionActual(int x, int y, int size) {
		positionManager.removePosition(x, y, size);
	}
	
	//Metodos Getters y Setters de la clase--------------
	public boolean getInGame() {
		return this.inGame;
	}
	
	public List<Entity> getEntityList () {
		return this.entityList;
	}
	
	public SnakeGame getSnakeGame() {
		return this.snakeGame;
	}
	
	public Snake getSnake() {
		return this.snake;
	}
	
	public LifeManager getLifeManager () {
		return this.lifeManager;
	}
	
	public ScoreManager getScoreManager () { 
        return this.scoreManager;
    }
	
	public PositionManager getPositionManager() {
		return this.positionManager;
	}
	
	public CollisionsManager getCollisionsManager() {
		return this.collisionManager;
	}
	
	public LevelManager getLevelManager() {
		return this.levelManager;
	}
	
	public Timer getTimer() {
		return this.timer;
	}
	
	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}
}
