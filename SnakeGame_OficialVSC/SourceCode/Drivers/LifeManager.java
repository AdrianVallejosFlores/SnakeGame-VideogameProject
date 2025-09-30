package Drivers;

/*
 * La clase LifeManager se encarga de gestionar las vidas del jugador en el juego.
 * Controla la cantidad de vidas disponibles y su visibilidad. 
 * Permite perder vidas y verificar si el jugador aún tiene vidas restantes.
 */
public class LifeManager {
    private int lives;
    private boolean visible;

    public LifeManager() {
    	this.visible = true;
    	this.lives = 3;
    }

    public void loseLife() {
        if (lives > 0) {
            lives--;
        } 
    }
  
    public boolean hasLives() {
        return lives > 0;
    }
    
    public int getLives() {
    	if (!this.visible) {
    		this.lives = 0;
    	}
        return lives;
    }
    
    public void setVisible (boolean visible) {
    	this.visible = visible;
    }
}