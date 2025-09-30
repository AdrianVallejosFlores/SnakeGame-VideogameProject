package Drivers;

import Objects.GameSettings;

/**
 * La clase ScoreManager se encarga de gestionar la puntuación del jugador,
 * incluyendo la puntuación actual y la puntuación más alta registrada.
 */
public class ScoreManager {
    private int score;
    private int highScoreEasy;
    private int highScoreHard;
    private GameSettings.Dificulty dificultyActual;

    public ScoreManager() {
        this.score = 0;
        this.highScoreHard = 0;
        this.highScoreEasy = 0;
    }
    
    public void increaseScore(int amount) {
        this.score += amount;
        
        if((this.dificultyActual == GameSettings.Dificulty.EASY) && (score > highScoreEasy)) {
        	highScoreEasy = score; 
            
        }
        if((this.dificultyActual == GameSettings.Dificulty.HARD) && (score > highScoreHard)) {
        	highScoreHard = score;   
        } 
    }

    public void resetScore() {
        this.score = 0; 
    }
    
    public int getScore() {
        return this.score;
    }

    public int getHighScoreHard() {
        return this.highScoreHard;
    }
    
    public int getHighScoreEasy() {
        return this.highScoreEasy;
    }
    
    public GameSettings.Dificulty getDifficulty () {
    	return this.dificultyActual;
    }
    
    public void setDifficultyActual (GameSettings.Dificulty difficulty) {
    	this.dificultyActual = difficulty;
    }
}