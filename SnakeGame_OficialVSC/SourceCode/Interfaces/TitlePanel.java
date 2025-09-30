package Interfaces;

import Objects.Images;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.InputStream;

/*
 * La clase TitlePanel maneja la pantalla de título del juego. Muestra los títulos 
 * "SNAKE", "GAME" y "GALACTIC" con fuentes personalizadas en diferentes colores
 * Además, incluye un efecto de parpadeo en el texto y maneja la entrada de teclas 
 * para comenzar el juego.
 */
public class TitlePanel extends JPanel {
	
	private JLabel snakeLabel;
	private JLabel gameLabel;
	private JLabel galacticLabel;
	private JLabel pressKeyLabel;

    public TitlePanel() {
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        createTitleComponents();
        setupKeyListener();
    }

    private void createTitleComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;

        this.snakeLabel = new JLabel("SNAKE");
        this.snakeLabel.setFont(loadPixelFont(77));
        this.snakeLabel.setForeground(Color.GREEN);
        add(this.snakeLabel, gbc);

        gbc.gridy++;
        this.gameLabel = new JLabel("GAME");
        this.gameLabel.setFont(loadPixelFont(77));
        this.gameLabel.setForeground(Color.RED);
        add(this.gameLabel, gbc);

        gbc.gridy++;
        this.galacticLabel = new JLabel("GALACTIC");
        this.galacticLabel.setFont(loadPixelFont(77));
        this.galacticLabel.setForeground(Color.BLUE);
        add(this.galacticLabel, gbc);

        gbc.gridy++;
        gbc.weighty = 1.0;
        JPanel fillerPanel = new JPanel();
        fillerPanel.setOpaque(false);  
        add(fillerPanel, gbc);

        gbc.gridy++;
        gbc.weighty = 0;
        gbc.anchor = GridBagConstraints.SOUTH;
        gbc.insets = new Insets(20, 0, 30, 0);

        this.pressKeyLabel = new JLabel("Press Enter or Space key to enter");
        this.pressKeyLabel.setFont(loadPixelFont(25)); 
        this.pressKeyLabel.setForeground(Color.WHITE); 
        add(this.pressKeyLabel, gbc);
        setupBlinkingEffect(this.pressKeyLabel);
    }

    private void setupBlinkingEffect(JLabel label) {
        Timer blinkTimer = new Timer(300, e -> label.setVisible(!label.isVisible()));
        blinkTimer.start();
    }

    private void setupKeyListener() {
        setFocusable(true);
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                	System.out.println("1");
                	((Menu) SwingUtilities.getWindowAncestor(TitlePanel.this)).showMenuButton();
                }
            }
        });
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
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (Images.FONDO != null) {
            g.drawImage(Images.FONDO, 0, 0, getWidth(), getHeight(), this); 
        }
    }
    
    public JLabel getSnakeLabel () {
    	return this.snakeLabel;
    }
    
    public JLabel getGameLabel () {
    	return this.gameLabel;
    }
    
    public JLabel getGalacticLabel () {
    	return this.galacticLabel;
    }
    
    public JLabel getPressKeyLabel () {
    	return this.pressKeyLabel;
    }
}