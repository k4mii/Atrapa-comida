package autonoma.atrapacomida.models;

import java.awt.image.BufferedImage;

/**
 * @author Maria Camila Prada Cortes
 * @version 1.0.0
 * @since 2025-05-10
 */
public class Element {

    // Atributos
    /**
     * La posición horizontal del elemento en la pantalla.
     */
    int x;

    /**
     * La posición vertical del elemento en la pantalla.
     */
    int y;

    /**
     * La imagen asociada al elemento (comida o veneno).
     */
    BufferedImage imagen;

    /**
     * El tipo de elemento ("comida" o "veneno").
     */
    String tipo;

    /**
     * Constructor que inicializa un nuevo elemento con la posición, la imagen y
     * el tipo.
     *
     * @param x La posición horizontal del elemento.
     * @param y La posición vertical del elemento.
     * @param imagen La imagen que representa al elemento.
     * @param tipo El tipo de elemento ("comida" o "veneno").
     */
    public Element(int x, int y, BufferedImage imagen, String tipo) {
        this.x = x;
        this.y = y;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    /**
     * Verifica si un punto dado por las coordenadas del ratón está dentro de
     * los límites del elemento (esto se usa para determinar si el jugador ha
     * hecho clic sobre él).
     *
     * @param mx La coordenada X del ratón.
     * @param my La coordenada Y del ratón.
     * @return {@code true} si el ratón está sobre el elemento, {@code false} en
     * caso contrario.
     */
    public boolean contains(int mx, int my) {
        return (mx >= x && mx <= x + imagen.getWidth() && my >= y && my <= y + imagen.getHeight());
    }

    /**
     * Mueve el elemento hacia abajo en la pantalla. Este método se utiliza para
     * simular el movimiento de caída de los elementos.
     */
    public void mover() {
        y += 5;  // Mueve el elemento 5 píxeles hacia abajo en cada ciclo de actualización.
    }

    /**
     * Dibuja el elemento en la pantalla usando la imagen asociada en las
     * coordenadas (x, y).
     *
     * @param g El objeto {@code Graphics} usado para dibujar el elemento en la
     * pantalla.
     */
    public void dibujar(java.awt.Graphics g) {
        g.drawImage(imagen, x, y, null);
    }
}
