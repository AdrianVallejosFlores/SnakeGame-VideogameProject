package Objects;

/**
* La clase GameSettings define las configuraciones del juego, 
* incluyendo las direcciones de movimiento, los niveles de dificultad 
* y los niveles del juego.
* 
* Enumeraciones:
* - Directions: Representa las posibles direcciones de movimiento 
*   en el juego (RIGHT, LEFT, UP, DOWN).
* - Dificulty: Define los niveles de dificultad disponibles 
*   en el juego (HARD, EASY).
* - Levels: Enumera los niveles del juego disponibles, desde 
*   ONE hasta THIRTEEN(Modificable).
*/
public class GameSettings {

    public enum Directions {
        RIGHT, LEFT, UP, DOWN
    }
    
    public enum Dificulty {
        HARD, EASY
    }
    
    public enum Levels {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGTH, NINE, TEN, ELEVEN, TWELVE, THIRTEEN
    }
}