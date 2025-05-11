package autonoma.atrapacomida.models;

import gamebase.elements.EscritorArchivoTextoPlano;
import gamebase.elements.LectorArchivoTextoPlano;
import gamebase.elements.Sprite;
import gamebase.elements.SpriteContainer;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * clase que represente el “espacio” donde caen las comidas y venenos.
 *
 * @author Maria Camila Prada Cortes
 * @version 1.0.0
 * @since 2025-05-10
 */
public class FoodField extends SpriteContainer {

    /**
     * Atributos
     */
    /**
     * Atributo de la instancia de la clase Player
     */
    private Player player;

    /**
     * Atributo la lista de sprite que contiene los alimentos y veneno
     */
    private ArrayList<Sprite> sprites;

    protected FoodSpawner foodSpawner;

    protected PoisonSpawner poisonSpawner;

    private EscritorArchivoTextoPlano escritor;
    private LectorArchivoTextoPlano lector;

    private int maxScore = 0;

    /**
     * Constructor
     */
    public FoodField(int x, int y, int height, int width) {
        super(x, y, height, width);
        this.sprites = new ArrayList<>();
        
        this.foodSpawner = new FoodSpawner(this);
        this.foodSpawner.start();
        
        this.poisonSpawner = new PoisonSpawner(this);
        this.poisonSpawner.start();
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Metodos de acceso
     */
    public Player getPlayer() {
        return player;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    /**
     * Metodo para agregar la pulga normal al campo de batalla
     */
    public void addFood() {
        ElementType e = null;

        try {
            e = ElementType.create(Food.class, width, height, sprites);
        } catch (InstantiationException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        }

        sprites.add(e);
        refresh();
    }

    /**
     * Metodo para agregar el veneno a Food field
     */
    public void addPosion() {
        ElementType e = null;

        try {
            e = ElementType.create(Posion.class, width, height, sprites);
        } catch (InstantiationException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        }

        sprites.add(e);
        refresh();
    }

    /**
     * Elimina una pulga del campo de batalla. Este método elimina la pulga
     * especificada de la lista de sprites activos y aumenta el puntaje del
     * jugador en 1 punto por cada pulga eliminada. Si después de eliminar la
     * pulga ya no quedan más pulgas en el campo de batalla,
     *
     * @param pulga
     */
    public void eliminarElement(ElementType element) {
        // Aumenta el puntaje del jugador por cada pulga eliminada
        sprites.remove(element);
    }

    @Override
    public void paint(Graphics g) {
        for (Sprite sprite : sprites) {
            sprite.paint(g);
        }
    }

    @Override
    public void refresh() {
        if (gameContainer != null) {
            gameContainer.refresh();
        }
    }

    @Override
    public Rectangle getBoundaries() {
        return new Rectangle(x, y, width, height);
    }

}
