package Drivers;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.InputStream;

/* La clase AudioPlayer sera la que maneje la ejecucion de la cancion del 
 * del juego, en donde tiene funciones basicas de encendido y apagado 
 * de la pista de musica
 */
public class AudioPlayer {
    private static final String DEFAULT_AUDIO_PATH = "/MUSIC_SNAKE_GAME.wav";
    private float DECIBELS = -20.0f;
    private Clip clip;

    public AudioPlayer() {
        try {
            InputStream audioSrc = getClass().getResourceAsStream(DEFAULT_AUDIO_PATH);
            if (audioSrc == null) {
                throw new IllegalArgumentException("Archivo de audio no encontrado" + DEFAULT_AUDIO_PATH);
            }

            InputStream bufferedIn = new java.io.BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            setVolume(DECIBELS);
            
        } catch (Exception e) {
            System.err.println("Error al cargar el audio: " + e.getMessage());
        }
    }

    public void playLoop() {
        if (clip != null) {
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }
    
    public Clip getClip () {
    	return this.clip;
    }
    
    private void setVolume(float decibels) {
        if (clip != null) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(decibels);
        }
    }
}
