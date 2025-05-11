package autonoma.atrapacomida.main;

import autonoma.atrapacomida.views.GameWindow;



/**
 * La clase main, crea y muestra la ventana.
 * @author Camila prada
 * @version 1.0.0
 * @since 2025-05-02
 */
public class Main {

    public static void main(String[] args) {
        /**
         * Se crea la ventana inicial para comenzar con la ejecucion del juego
         */
        GameWindow ventana = new GameWindow();
        ventana.setVisible(true);

    }
}
