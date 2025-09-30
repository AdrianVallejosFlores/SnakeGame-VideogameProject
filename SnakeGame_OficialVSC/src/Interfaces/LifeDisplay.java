package Interfaces;

import Drivers.LifeManager;
import Objects.Images;
import javax.swing.*;
import java.awt.*;

/**
 * La clase LifeDisplay es un componente gráfico que muestra la vida restante del jugador
 * utilizando íconos de corazones. Esta clase es responsable de renderizar la cantidad de vidas
 * en la pantalla.
 */
public class LifeDisplay extends JPanel {
	
	private final int HEART_SIZE = 40;
    private LifeManager lifeManager;
    private boolean visible;

    public LifeDisplay(LifeManager lifeManager) {
    	this.visible = true;
        this.lifeManager = lifeManager;
        setPreferredSize(new Dimension(200, 50));
    }
    
    public void draw(Graphics g) {
    	if (!this.visible) return; 
        for (int i = 0; i < lifeManager.getLives(); i++) {
            Image heartImage = Images.HEART; 
            if (heartImage != null) {
                g.drawImage(heartImage, 1210 + i * 30, 0, this.HEART_SIZE, this.HEART_SIZE, null); 
            }
        }
    }
    
    public boolean getVisible () {
    	return this.visible;
    }
    
    public void setVisible (boolean visible) {
    	this.visible = visible;
    	if (!this.visible) {
    		this.lifeManager.setVisible(this.visible);
    	}
    }
}