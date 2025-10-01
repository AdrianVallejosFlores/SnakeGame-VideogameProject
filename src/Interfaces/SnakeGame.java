package Interfaces;

import Drivers.*;
import Objects.Entity;
import Objects.GameSettings;
import Objects.Images;
import javax.swing.*;
import java.awt.*;

/**
 * La clase SnakeGame representa el juego de Snake. Es el panel principal donde se dibujan 
 * los elementos del juego, como el puntaje, las vidas y la serpiente. 
 */
public class SnakeGame extends JPanel{
	
    //Dimension de la ventana del juego
    private final int WIDTH = 1340; 
    private final int HEIGHT = 700;
    
    private ScoreManager scoreManager;
    private LifeDisplay lifeDisplay;
    private ScoreDisplay scoreDisplay;
    private LevelDisplay levelDisplay;
    private MotionSnake motionSnake; 
    private GameEngine gameEngine;
    private GameSettings.Dificulty dificulty;
    private boolean visible = true;
    
    public SnakeGame(ScoreManager scoreManager, GameSettings.Dificulty dificulty) {
    	initBoard(scoreManager,  dificulty);
    	this.scoreManager = scoreManager;
    	this.scoreManager.setDifficultyActual(dificulty);
    	this.dificulty = dificulty;
    }
   
    private void initBoard(ScoreManager scoreManager, GameSettings.Dificulty dificulty) {
        setPreferredSize(new Dimension(getWidth(), getHeight())); 
        setFocusable(true); 
        requestFocusInWindow(); 

        //Inicializa los componentes del juego(Motor de Juego y Displays)
        this.gameEngine = new GameEngine(this, scoreManager);
        this.scoreDisplay = new ScoreDisplay(scoreManager);
        this.lifeDisplay = new LifeDisplay(gameEngine.getLifeManager());
        this.levelDisplay = new LevelDisplay(gameEngine.getLevelManager()); 
        this.motionSnake = new MotionSnake(gameEngine.getSnake());
        
        //Establece la visibilidad de las vidas según la dificultad
        if (dificulty != GameSettings.Dificulty.EASY) {
            this.lifeDisplay.setVisible(false);
        }

        //Agrega un listener para los movimientos de la serpiente
        addKeyListener(this.motionSnake);
    }
    
    public void initGameValid () {
    	if (this.visible) gameEngine.startGame(); 
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawObjects(g);
    }

    private void drawObjects(Graphics g) {
    	g.drawImage(Images.FONDO_SG, 0, 0, this.WIDTH, this.HEIGHT, this); // se agregooooooooooooooooo    	
    	gameEngine.getSnake().draw(g); 
        scoreDisplay.draw(g);
        lifeDisplay.draw(g);
        levelDisplay.draw(g); 
        
        for (Entity entity: gameEngine.getEntityList()) {
        	entity.draw(g);
        }
    }
    
    //Metodo Getters y Setters de la clase---------
    public GameEngine getGameEngine() {
    	return this.gameEngine;
    }
    
    public LevelDisplay getLevelDisplay() {
    	return this.levelDisplay;
    }
    
    public MotionSnake getMotionSnake () {
    	return this.motionSnake;
    }
    
    public ScoreDisplay getScoreDisplay () {
    	return this.scoreDisplay;
    }
    
    public LifeDisplay getLifeDisplay () {
    	return this.lifeDisplay;
    }
    
    public GameSettings.Dificulty getDificulty () {
    	return this.dificulty;
    }
    
    public int getWidth() {
    	return this.WIDTH;
    }
    
    public int getHeight() {
    	return this.HEIGHT;
    }
    
    public void setVisible (boolean visible) {
    	this.visible = visible;
    }
}