package autonoma.atrapacomida.models;

import autonoma.atrapacomida.views.GameWindow;

/**
 *
 * @author Kamii
 */
public class RefreshProgram implements Runnable{
    
    private FoodField foodField;
    private GameWindow gameWindow;
    private boolean running;
    private Thread thread;

    public RefreshProgram(FoodField foodField, GameWindow gameWindow) {
        this.foodField = foodField;
        this.gameWindow = gameWindow;
        running = false;
    }

    @Override
    public void run() {
        running = true;
        while (running) {
            foodField.update();  // mueve los elementos y refresca
            try {
                Thread.sleep(30);  // 30ms como lo planeabas
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void stop() {
        running = false;
    }
}
