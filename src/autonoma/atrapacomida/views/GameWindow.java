package autonoma.atrapacomida.views;

import autonoma.atrapacomida.models.FoodField;
import gamebase.elements.GraphicContainer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author Kamii
 */
public class GameWindow extends javax.swing.JFrame implements GraphicContainer {

    private FoodField foodField;

    /**
     * Creates new form GameWindow
     */
    public GameWindow() {
        setUndecorated(true);
        initComponents();
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        try {
            this.setIconImage(new ImageIcon(getClass().getResource("/autonoma/atrapacomida/images/hamburguer.png")).getImage());
        } catch (Exception e) {
            System.out.println("imagen no encontrada");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyPressed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        System.out.println("¡Clic detectado!");
        if (foodField != null) {
            foodField.handleClick(evt.getPoint());
            foodField.refresh();  // Asegúrate de llamar a refresh después de manejar el clic
            repaint();  // Refresca la pantalla
        }
    }//GEN-LAST:event_formMouseClicked
    public void setFoodField(FoodField foodField) {
        this.foodField = foodField;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // Esto es importante para que se repinten correctamente los componentes
        System.out.println("Repintando la ventana...");
        // Fondo color cielo azul claro
        g.setColor(new Color(135, 206, 235));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Pintar el FoodField encima del fondo
        if (foodField != null) {
            foodField.paint(g);
            if (foodField.getPlayer() != null) {
                g.setColor(Color.BLACK);
                g.drawString("Puntaje: " + foodField.getPlayer().getPuntaje(), 20, 50);
            }
        }

    }

    /**
     * Refresca la interfaz gráfica de la ventana del juego.
     */
    @Override
    public void refresh() {
        this.repaint();
    }

    /**
     * Este método devuelve el rectángulo que representa los límites de la
     * ventana del juego (la posición y el tamaño de la ventana).
     *
     * @return
     */
    @Override
    public Rectangle getBoundaries() {
        return this.getBounds();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
