package Drivers;

import Objects.GameSettings;

/**
 * La clase LevelManager es responsable de gestionar los niveles del juego 
 * en función de la puntuación del jugador. Realiza un seguimiento del nivel 
 * actual y ejecuta las acciones asociadas a cada nivel cuando la puntuación 
 * alcanza umbrales específicos.
 */
public class LevelManager {

	private GameEngine gameEngine;
	private GameSettings.Levels levelActual;
	
	public LevelManager (ScoreManager scoreManager, GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		this.levelActual = GameSettings.Levels.ZERO;
	}

	public void reviewLevels (int score) {
		switch (this.levelActual) {
			case ZERO -> {if(score >= 0) executeLevelONE();}
			case ONE -> {if(score >= 500) executeLevelTWO();}
			case TWO -> {if(score >= 1000) executeLevelTHREE();}
			case THREE -> {if(score >= 2000) executeLevelFOUR();}
			case FOUR -> {if(score >= 2500) executeLevelFIVE();}
			case FIVE -> {if(score >= 3500) executeLevelSIX();}
			case SIX -> {if(score >= 4500) executeLevelSEVEN();} 
			case SEVEN -> {if(score >= 5500) executeLevelEIGTH();}
			case EIGTH -> {if(score >= 6500) executeLevelNINE();}
			case NINE -> {if(score >= 8500) executeLevelTEN();}
		}
	}
	
	private void executeLevelONE() {
		this.levelActual = GameSettings.Levels.ONE;
		gameEngine.addEntityApple();
	}
	
	private void executeLevelTWO () {
		this.levelActual = GameSettings.Levels.TWO;
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelTHREE () {
		this.levelActual = GameSettings.Levels.THREE;
		gameEngine.addEntityOrange();
		gameEngine.removeEntityBlackHole();
	}
	
	private void executeLevelFOUR () {
		this.levelActual = GameSettings.Levels.FOUR;
		gameEngine.addEntityApple();
		gameEngine.addEntityBlackHole();
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelFIVE () {
		this.levelActual = GameSettings.Levels.FIVE;
		gameEngine.addEntityOrange();
		gameEngine.removeEntityBlackHole();
	}
	
	private void executeLevelSIX () {
		this.levelActual = GameSettings.Levels.SIX;
		gameEngine.addEntityBlackHole();
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelSEVEN () {
		this.levelActual = GameSettings.Levels.SEVEN;
		gameEngine.addEntityBlackHole();
		gameEngine.addEntityApple();
		gameEngine.removeEntityOrange();
	}
	
	private void executeLevelEIGTH () {
		this.levelActual = GameSettings.Levels.EIGTH;
		gameEngine.addEntityOrange();
		gameEngine.removeEntityApple();
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelNINE () {
		this.levelActual = GameSettings.Levels.NINE;
		gameEngine.addEntityBlackHole();
	}
	
	private void executeLevelTEN () {
		this.levelActual = GameSettings.Levels.TEN;
		gameEngine.addEntityBlackHole();
	}
	
	public GameSettings.Levels getLevelActual() {
		return this.levelActual;
	}
}