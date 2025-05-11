package autonoma.atrapacomida.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Clase responsable de cargar y almacenar los sprites del juego. Centraliza las
 * imágenes para evitar cargarlas repetidas veces.
 *
 * @author Maria Camila Prada Cortes
 * @version 1.0.0
 * @since 2025-05-10
 */
public class GestorSprites {

    /**
     * Imagen de la comida, utilizada por los elementos de tipo "comida".
     */
    public static BufferedImage eat;
    /**
     * Imagen del veneno, utilizada por los elementos de tipo "veneno".
     */
    public static BufferedImage pocion;

    /**
     * Método que carga todos los sprites del juego. Este método se debe llamar
     * una vez al iniciar el juego.
     */
    public static void cargarSprites() {
        try {
            // Cargamos la imagen de comida (hamburguesa)
            eat = cargarImagen("/autonoma/atrapacomida/images/hamburguer.png");

            // Cargamos la imagen de veneno (cigarrillo)
            pocion = cargarImagen("/autonoma/atrapacomida/images/pocion.png");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que carga una imagen desde una ruta y la convierte en un
     * BufferedImage con transparencia. Implementa el fragmento de código del
     * tutorial de Java 2D Graphics.
     *
     * @param ruta La ruta del archivo de imagen.
     * @return BufferedImage con la imagen cargada.
     * @throws IOException Si no se puede leer la imagen.
     */
    public static BufferedImage cargarImagen(String ruta) throws IOException {
        // Lee la imagen desde un archivo
        BufferedImage img = ImageIO.read(new File(ruta));

        // Obtiene dimensiones
        int w = img.getWidth(null);
        int h = img.getHeight(null);

        // Crea un nuevo BufferedImage con canal alfa (transparencia)
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

        // Obtiene el contexto gráfico para dibujar en bi
        Graphics g = bi.getGraphics();

        // Dibuja la imagen original sobre el nuevo BufferedImage
        g.drawImage(img, 0, 0, null);

        return bi;
    }
}
