package Objects;

import Drivers.PositionManager;
import java.awt.geom.AffineTransform;
import java.util.concurrent.ThreadLocalRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.Timer;

/**
* Representa un agujero negro en el juego que puede aparecer y desaparecer en
* posiciones aleatorias en la pantalla. El agujero negro gira lentamente y su
* visibilidad se alterna a intervalos aleatorios
*/
public class BlackHole extends Entity implements ActionListener {
    private int width;
    private int height;
    private Timer timer;
    private double angle = 0;

    public BlackHole(int width, int height, PositionManager posMan) {
        super(width, height, posMan);
        this.ENTITY_SIZE = 80;
        this.width = width;
        this.height = height;
        locationBlackHole();
        loadBlackHole();
    }

    public void loadBlackHole() {
        timer = new Timer(generateDelay(), this);
        timer.start();
    }

    public void resetLocation() {
        timer.restart();
    }

    private int generateDelay() {
        return ThreadLocalRandom.current().nextInt(5, 7) * 1000;
    }

    public void locationBlackHole() {
        posX = ThreadLocalRandom.current().nextInt((width / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        posY = ThreadLocalRandom.current().nextInt((height / ENTITY_SIZE) - 1) * ENTITY_SIZE;
        if (posMan.overlay(posX, posY, ENTITY_SIZE)) {
            locationBlackHole();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.setDelay(generateDelay());
        visible = !visible;
        if (visible) {
            locationBlackHole();
        } else {
            posX = -this.ENTITY_SIZE;
            posY = -this.ENTITY_SIZE;
        }
    }

    @Override
    public void draw(Graphics g) {
        if (visible) {
            angle -= Math.toRadians(2);

            Graphics2D graphics2d = (Graphics2D) g;
            AffineTransform oldTransform = graphics2d.getTransform();

            int centerX = this.posX + this.ENTITY_SIZE / 2;
            int centerY = this.posY + this.ENTITY_SIZE / 2;

            graphics2d.rotate(angle, centerX, centerY);
            graphics2d.drawImage(Images.BLACK_HOLE, this.posX, this.posY, this.ENTITY_SIZE, this.ENTITY_SIZE, null);
            graphics2d.setTransform(oldTransform);
        } else {
            this.posX = -this.ENTITY_SIZE;
            this.posY = -this.ENTITY_SIZE;
        }
    }
}
