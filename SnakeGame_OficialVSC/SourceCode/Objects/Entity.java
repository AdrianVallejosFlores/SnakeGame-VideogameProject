package Objects;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import Drivers.PositionManager;

/**
 * La clase Entity representa un objeto general en el juego con una posición
 * y un estado de visibilidad definidos.
 * Esta clase sirve como base abstracta para tipos de entidades más específicos.
 * Requiere que las subclases implementen el método draw().
 */

public abstract class Entity {
    protected int ENTITY_SIZE = 40;
    protected int posX;
    protected int posY;
    protected boolean visible;
    protected PositionManager posMan;

    public Entity(int width, int height, PositionManager posMan) {
        this.posMan = posMan;
        this.visible = true;
        location(width, height); 
    }
    
    public abstract void draw(Graphics g);
    
    public void location(int width, int height) {
        posX = ThreadLocalRandom.current().nextInt((width / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        posY = ThreadLocalRandom.current().nextInt((height / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        if (posMan.overlay(posX, posY, ENTITY_SIZE)) { //Evita la sobreposicion de entidades
            location(width, height); 
        }
    }
    
    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }

    public int getSize() {
        return ENTITY_SIZE;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}