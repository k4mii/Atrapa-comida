package autonoma.atrapacomida.models;

import gamebase.elements.EscritorArchivoTextoPlano;
import gamebase.elements.LectorArchivoTextoPlano;
import gamebase.elements.Sprite;
import gamebase.elements.SpriteContainer;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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

    String[] options = {"Sí", "No"};

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
        
        this.escritor = new EscritorArchivoTextoPlano("Score.txt");
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
        Food f = null;

        try {
            f = ElementType.create(Food.class, width, height, sprites);
        } catch (InstantiationException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        }

        sprites.add(f);
        refresh();
    }

    /**
     * Metodo para agregar la pulga mutante al campo de batalla
     */
    public void addMutantFlea() {
        Posion p = null;

        try {
            p = ElementType.create(Posion.class, width, height, sprites);
        } catch (InstantiationException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FoodField.class.getName()).log(Level.SEVERE, null, ex);
        }

        sprites.add(p);
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
    public void eliminarPulga(Food food) {
        // Aumenta el puntaje del jugador por cada pulga eliminada
        this.player.aumentarPuntaje(1);
        sprites.remove(food);
    }

    /**
     * Maneja el fin de la partida, ofreciendo la opción de reiniciar el juego o
     * finalizarlo. Este método detiene el generador de pulgas y muestra un
     * cuadro de diálogo al jugador preguntando si desea reiniciar la partida.
     * Si el jugador elige reiniciar, se restablece el puntaje a cero y se
     * inicia nuevamente el generador de pulgas. Si el jugador decide finalizar
     * la partida, se guarda su puntaje en un archivo y se muestra el puntaje
     * máximo alcanzado en la pantalla. Finalmente, el juego se cierra.
     */
    private void manejarFinDePartida() {
        // Detenemos el generador de pulgas
        this.fleaSpawner.stop();
        int opcion = JOptionPane.showOptionDialog(
                null,
                "¿Quieres reiniciar la partida?",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        boolean continuar = (opcion == JOptionPane.YES_OPTION);
        if (continuar) {
            // Reiniciamos el puntaje y refrescamos el campo de batalla
            this.player.setPuntaje(0);
            this.refresh();
            this.fleaSpawner.start();
        } else {
            JOptionPane.showMessageDialog(null, " Gracias por jugar :)");
            try {
                // Guardamos el puntaje
                Score score = new Score("puntajes.txt");
                score.guardarPuntaje(player.getPuntaje());

                // Leemos todos los puntajes guardados
                ArrayList<Integer> puntajes = score.leerPuntajes();

                // Si el puntaje actual es el más alto, actualizamos el puntaje máximo
                if (!puntajes.isEmpty()) {
                    int nuevoMax = Collections.max(puntajes);
                    if (nuevoMax > maxScore) {
                        maxScore = nuevoMax;
                    }
                }

                // Actualizamos la pantalla con el nuevo puntaje máximo
                if (gameContainer instanceof GameWindow) {
                    ((GameWindow) gameContainer).setMaxScore(maxScore);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al guardar puntaje: " + e.getMessage());
            }
            System.exit(0);
        }

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
