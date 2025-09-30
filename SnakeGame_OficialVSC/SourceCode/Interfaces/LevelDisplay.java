package Interfaces;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.IOException;
import java.io.InputStream;
import Drivers.LevelManager;

/**
 * La clase LevelDisplay se encarga de mostrar el nivel actual del juego en la interfaz gráfica.
 * Utiliza una fuente personalizada (Pixel Font) para renderizar el texto en la pantalla.
 * El nivel actual es obtenido de un objeto LevelManager, y el texto es dibujado en color blanco
 * en una posición fija de la ventana.
 */
public class LevelDisplay {
	private LevelManager levelManager;
	private Font pixelFont;
	
	public LevelDisplay (LevelManager lm) {
		this.pixelFont = loadPixelFont(30);
		this.levelManager = lm;
	}
	
	 private Font loadPixelFont(int size) {
	     try {
	          InputStream fontStream = getClass().getResourceAsStream("/PressStart2P-Regular.ttf");
	          Font font = Font.createFont(Font.TRUETYPE_FONT, fontStream);
	          return font.deriveFont(Font.BOLD, size);  
	     } catch (FontFormatException | IOException e) {
	          e.printStackTrace();
	          return new Font("SansSerif", Font.BOLD, size);  
	     }
	 }

	 public void draw(Graphics g) {
		 String level = this.levelManager.getLevelActual().name();
		 g.setColor(Color.WHITE);
	     g.setFont(pixelFont);
	     g.drawString("LEVEL:" + level , 750, 35); 
	 }
	    
	 public Font getPixelFont () {
		 return this.pixelFont;
	 }
}
