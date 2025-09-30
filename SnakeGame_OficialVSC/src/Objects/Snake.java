package Objects;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/*
 * La clase Snake representa la serpiente en el juego, gestionando su tamaño, dirección,
 * posición y visibilidad. Proporciona métodos para moverla, dibujarla en la pantalla y
 * manejar su inmunidad.
 */
public class Snake {

	private final GameSettings.Directions[] registerDirection;
    private final int SNAKE_RECT_SIZE = 20;
    private final int[] posX;
    private final int[] posY; 
    private boolean visible;
    private boolean inmunity;
    private int snakeSize; 
    private GameSettings.Directions direction;
    
    public Snake(int snakeSize) {
    	this.registerDirection = new GameSettings.Directions[900];
    	this.direction = GameSettings.Directions.RIGHT;
    	this.snakeSize = snakeSize;
        this.posX = new int[900];  
        this.posY = new int[900];
        this.inmunity = false;
        this.visible = true;
    
        initSnake();
    }
    
    private void initSnake() {
        for (int i = 0; i < snakeSize; i++) {
            posX[i] = 60 - i * 10;
            posY[i] = 60;
        }
    }
    
    public void blinkSnake () {
    	setVisible(false);
		setInmunity(true);
		Timer blinkTimer = new Timer(150, new ActionListener() {
	        private int blinkCount = 0;
	        
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            setVisible(!getVisible());
	            blinkCount++;
	            if (blinkCount >= 30) {  
	                ((Timer) e.getSource()).stop();  
	                setVisible(true);  
	                setInmunity(false);
	            }
	        }
	    });
	    blinkTimer.start(); 
	}

    public void draw(Graphics g) {
    	if (visible) {
    		for (int i = 0; i < snakeSize; i++) {
                if (i == 0) {
                    g.drawImage(getHeadImage(registerDirection[i]), posX[i], posY[i], SNAKE_RECT_SIZE, SNAKE_RECT_SIZE, null);
                } else {
                	g.drawImage(getBodyImage(registerDirection[i]), posX[i], posY[i], SNAKE_RECT_SIZE, SNAKE_RECT_SIZE, null);
                }
            }
    	} 
    }
    
    public Image getBodyImage(GameSettings.Directions dir) {
    	if (dir == null) dir = GameSettings.Directions.RIGHT; 
        switch (dir) {
            case LEFT: return Images.SNAKE_BODY_LEFT;
            case UP: return Images.SNAKE_BODY_UP;
            case DOWN: return Images.SNAKE_BODY_DOWN;
            case RIGHT: return Images.SNAKE_BODY_RIGHT;
            default: return Images.SNAKE_BODY_RIGHT;
        }
    }
    
    public Image getHeadImage(GameSettings.Directions dir) {
    	if (dir == null) dir = GameSettings.Directions.RIGHT; 
        switch (dir) {
            case LEFT: return Images.SNAKE_HEAD_LEFT;
            case UP: return Images.SNAKE_HEAD_UP;
            case DOWN: return Images.SNAKE_HEAD_DOWN;
            case RIGHT: return Images.SNAKE_HEAD_RIGHT;
            default: return Images.SNAKE_HEAD_RIGHT;
        }
    }
    
    public void move() {
    	for(int i = snakeSize; i > 0; i--) {
    		posX[i] = posX[i - 1];
    		posY[i] = posY[i - 1];
    		registerDirection[i] = registerDirection[i - 1]; 
    	} 
    	
    	registerDirection[0] = direction; 
    	
    	switch (direction) {
	        case RIGHT -> posX[0] += SNAKE_RECT_SIZE;
	        case LEFT  -> posX[0] -= SNAKE_RECT_SIZE;
	        case DOWN  -> posY[0] += SNAKE_RECT_SIZE;
	        case UP    -> posY[0] -= SNAKE_RECT_SIZE;
    	}
    }
    
    public boolean movingRight() {
    	return direction == GameSettings.Directions.RIGHT;
    }
    
    public boolean movingLeft() {
    	return direction == GameSettings.Directions.LEFT;
    }
    
    public boolean movingUp() {
    	return direction == GameSettings.Directions.UP;
    }
    
    public boolean movingDown() {
    	return direction == GameSettings.Directions.DOWN;
    }
    
    public GameSettings.Directions getDirection () {
    	return this.direction;
    }
   
    public GameSettings.Directions getRegisterDirection (int n) {
    	return this.registerDirection[n];
    }
    
    public boolean inmunity (boolean valid) {
    	if(valid) return true;
    	return false;
    }
    
    //Metodos Getters y Setters de la clase--------------
    public boolean getInmunity () {
    	return this.inmunity;
    }
    
    public boolean getVisible () {
    	return this.visible;
    }
    
    public int getSnakeRectSize () {
    	return this.SNAKE_RECT_SIZE;
    }
    
    public int getSnakeSize () {
    	return this.snakeSize;
    }
    
    public int getSnakePosX (int x) {
    	return this.posX[x];
    }
    
    public int getSnakePosY (int y) {
    	return this.posY[y];
    }
    
    public void setSnakeSize(int sizeNew) {
        for (int i = snakeSize; i < sizeNew; i++) {
        	posX[i] = posX[snakeSize - 1];
            posY[i] = posY[snakeSize - 1];
            registerDirection[i] = registerDirection[snakeSize - 1];
        }
        this.snakeSize = sizeNew;
    }
    
    public void setDirection(GameSettings.Directions direction) {
    	if (direction != null) {  //Evita que la dirección sea null y se genera un IllegalException
            this.direction = direction;
        } 
    }
    
    public void setSnakePosX (int n) {
    	this.posX[0] = n;
    }
    
    public void setSnakePosY (int n) {
    	this.posY[0] = n;
    }
    
    public void setInmunity (boolean valid) {
    	this.inmunity = valid;
    }
   
    public void setVisible(boolean vs) {
    	this.visible = vs;
    }
}