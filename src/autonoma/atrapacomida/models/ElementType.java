package autonoma.atrapacomida.models;

import gamebase.elements.Sprite;
import gamebase.elements.SpriteMobile;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

/**
 *
 * @author Kamii
 */
public abstract class ElementType extends SpriteMobile {

    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    public ElementType(int x, int y, int width, int height) {
        super(x, y, height, width);
        setStep(step);
    }

    public boolean checkCollision(Point punto) {
        return punto.x >= this.getX() && punto.x <= this.getX() + this.getWidth()
                && punto.y >= this.getY() && punto.y <= this.getY() + this.getHeight();
    }

    public static ElementType create(Class type, int width, int height, List<Sprite> sprites)
            throws InstantiationException, IllegalAccessException {
        int x;
        int y = 0;
        boolean overlaps;

        do {
            x = (int) (Math.random() * (width - ElementType.WIDTH));
            overlaps = false;

            Rectangle newFleaRect = new Rectangle(x, y, ElementType.WIDTH, ElementType.HEIGHT);

            for (Sprite sprite : sprites) {
                if (sprite instanceof ElementType) {
                    Rectangle existingFleaRect = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
                    if (newFleaRect.intersects(existingFleaRect)) {
                        overlaps = true;
                        break;
                    }
                }
            }
        } while (overlaps);

        ElementType m = null;

        if (type.equals(Food.class)) {
            m = new Food(x, y, ElementType.WIDTH, ElementType.HEIGHT);
        } else if (type.equals(Posion.class)) {
            m = new Posion(x, y, ElementType.WIDTH, ElementType.HEIGHT);
        } else {
            System.out.println("ERROR: ElementType.create unknown type of flea");
        }

        return m;
    }

    /**
     * Método que debe implementar cada tipo de Alimento (Comida o Veneno)
     */
    public abstract void delete(FoodField foodField);

}
