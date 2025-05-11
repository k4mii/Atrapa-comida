package autonoma.atrapacomida.main;

import autonoma.atrapacomida.models.FoodField;
import autonoma.atrapacomida.views.GameWindow;



/**
 * La clase main, crea y muestra la ventana.
 * @author Camila prada
 * @version 1.0.0
 * @since 2025-05-02
 */
public class Main {
    public static void main(String[] args)
    {
        FoodField garden = new FoodField(0, 0, 500, 500);
        
        GameWindow window = new GameWindow();
        window.setGarden(garden);
        garden.setGraphicContainer(window);
        window.setSize(500, 500);
        window.setTitle("Come  o muere ");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
