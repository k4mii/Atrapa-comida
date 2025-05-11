package autonoma.atrapacomida.models;

/**
 *
 * @author Kamii
 */
public class PoisonThread implements Runnable{

    private FoodField foodField;
    private LienzoJuego lienzo;

    public PoisonThread(FoodField foodField, LienzoJuego lienzo) {
        this.foodField = foodField;
        this.lienzo = lienzo;
    }

    @Override
    public void run() {
        while (true) {
            foodField.moverComidas();
            lienzo.repaint();
            try {
                Thread.sleep(30);  // velocidad de caída
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
