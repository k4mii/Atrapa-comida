package autonoma.atrapacomida.models;



/**
 * @author Maria Camila Prada Cortes
 * @version 1.0.0
 * @since 2025-05-11
 */
public class Player {

    /**
     * Atributos
     */
    /**
     * Atributo del puntaje que tendra el jugador
     */
    private int puntaje;

    /**
     * Constructor
     */
    public Player(int x, int y, int height, int width) {
        this.puntaje = 0;
    }

    /**
     * Metodos de acceso
     */
    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void aumentarPuntaje(int score) {
        this.puntaje += score;
        System.out.println("Puntaje actualizado: " + puntaje);
    }


}
