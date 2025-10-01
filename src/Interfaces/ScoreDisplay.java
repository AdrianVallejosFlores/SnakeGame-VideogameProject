package Interfaces;

import Drivers.ScoreManager;
import Objects.GameSettings;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * La clase ScoreDisplay es responsable de mostrar el puntaje del jugador en la interfaz gráfica.
 * Utiliza una fuente personalizada y se encarga de cargarla y dibujar el puntaje en la pantalla.
 */
public class ScoreDisplay {
    private ScoreManager scoreManager;
    private Font pixelFont;

    public ScoreDisplay(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
        this.pixelFont = loadPixelFont(30);   
        scoreManager.resetScore();
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
        g.setColor(Color.WHITE);
        g.setFont(pixelFont);
        if (this.scoreManager.getDifficulty() == GameSettings.Dificulty.EASY) {
        	g.drawString(String.format("Score Easy:%07d", scoreManager.getScore()), 10, 35);
        } else {
        	g.drawString(String.format("Score Hard:%07d", scoreManager.getScore()), 10, 35);
        }
    }
    
    public Font getPixelFont () {
    	return this.pixelFont;
    }
}