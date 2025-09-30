package Drivers;

import Objects.GameSettings;
import Objects.Snake;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * La clase MotionSnake se encarga de manejar los eventos de teclado
 * para controlar el movimiento de la serpiente en el juego.
 */
public class MotionSnake extends KeyAdapter {
	
	private Snake snake;
	
	public MotionSnake(Snake snake) {
		this.snake = snake;
	}
	
	@Override
	public void keyPressed (KeyEvent e) {
		int button = e.getKeyCode();
		
		switch (button) {
	        case KeyEvent.VK_RIGHT -> { if (!snake.movingLeft()) snake.setDirection(GameSettings.Directions.RIGHT); }
	        case KeyEvent.VK_LEFT -> { if (!snake.movingRight()) snake.setDirection(GameSettings.Directions.LEFT); }
	        case KeyEvent.VK_UP -> { if (!snake.movingDown()) snake.setDirection(GameSettings.Directions.UP); }
	        case KeyEvent.VK_DOWN -> { if (!snake.movingUp()) snake.setDirection(GameSettings.Directions.DOWN); }
	    }
	}
}