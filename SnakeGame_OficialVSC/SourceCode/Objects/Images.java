package Objects;

import java.awt.*;
import javax.swing.*;

/**
 * La clase Images carga y almacena imágenes utilizadas en el juego. 
 * Las imágenes son accesibles a través de constantes estáticas, 
 * facilitando su uso en otras partes del código.
 */
public class Images {
	
	public static final Image ALIEN_1 = loadImage("/ALIEN 1.png");
	public static final Image ALIEN_2 = loadImage("/ALIEN 2.png");
	public static final Image BLACK_HOLE = loadImage("/BLACK HOLE.png");
	public static final Image SNAKE_HEAD_RIGHT = loadImage("/SNAKE HEAD RIGHT.png");
	public static final Image SNAKE_HEAD_LEFT = loadImage("/SNAKE HEAD LEFT.png");
	public static final Image SNAKE_HEAD_UP = loadImage("/SNAKE HEAD UP.png");
	public static final Image SNAKE_HEAD_DOWN = loadImage("/SNAKE HEAD DOWN.png");
	public static final Image SNAKE_BODY_RIGHT = loadImage("/SNAKE BODY RIGTH.png");
	public static final Image SNAKE_BODY_LEFT = loadImage("/SNAKE BODY LEFT.png");
	public static final Image SNAKE_BODY_UP = loadImage("/SNAKE BODY UP.png");
	public static final Image SNAKE_BODY_DOWN = loadImage("/SNAKE BODY DOWN.png");
	public static final Image HEART = loadImage("/HEART.png"); 
	public static final Image FONDO = loadImage("/FONDO.png");
	public static final Image FONDO_SG = loadImage("/FONDO_SG1.jpg");
	
	private static Image loadImage(String path) {
		return new ImageIcon(Images.class.getResource(path)).getImage();
	}
}