package autonoma.atrapacomida.models;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Maria Camila Prada Cortes
 * @version  1.0.0
 * @since 2025-05-11
 */
public class Posion extends ElementType{

    private Image posionImage;

    public Posion(int x, int y, int height, int width) {
        super(x, y, height, width);
        posionImage = new ImageIcon(getClass().getResource("/autonoma/atrapacomida/images/pocion.png")).getImage();

    }

    public void registerHit(FoodField foodField) {
        delete(foodField);
    }

    @Override
    public void delete(FoodField foodField) {
        foodField.eliminarPulga(this);
        foodField.getPlayer().setPuntaje(
                foodField.getPlayer().getPuntaje() + 1
        );
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(posionImage, x, y, null);
    }
}
