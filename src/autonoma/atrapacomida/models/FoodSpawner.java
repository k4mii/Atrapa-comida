package autonoma.atrapacomida.models;

import autonoma.atrapacomida.views.GameWindow;

/**
 *
 * @author Kamii
 */
    public class FoodSpawner implements Runnable{
    private FoodField foodField;
    private GameWindow gameWindow;

    public FoodSpawner(FoodField foodField, GameWindow gameWindow) {
        this.foodField = foodField;
        this.gameWindow = gameWindow;
    }

    @Override
    public void run() {
        while (true) {
            for (ElementoCaida comida : comidas) {
                comida.mover();
            }
            panel.repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

