package autonoma.atrapacomida.main;

import autonoma.atrapacomida.models.FoodField;
import autonoma.atrapacomida.models.Player;
import autonoma.atrapacomida.models.RefreshProgram;
import autonoma.atrapacomida.views.GameWindow;

/**
 * La clase main, crea y muestra la ventana.
 *
 * @author Camila prada
 * @version 1.0.0
 * @since 2025-05-02
 */
public class Main {

    public static void main(String[] args) {
        Player player = new Player(0, 0, 50, 50);
        FoodField foodField = new FoodField(0, 0, 500, 500);
        foodField.setPlayer(player);
        GameWindow window = new GameWindow();
        window.setFoodField(foodField);
        foodField.setGraphicContainer(window);
        window.setSize(500, 500);
        window.setTitle("Come  o muere ");
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        RefreshProgram gameLoop = new RefreshProgram(foodField, window);
        gameLoop.start();
    }
}
