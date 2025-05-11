package autonoma.atrapacomida.models;

import java.util.ArrayList;

/**
 * clase que represente el “espacio” donde caen las comidas y venenos.
 *
 * @author Maria Camila Prada Cortes
 * @version 1.0.0
 * @since 2025-05-10
 */
public class FoodField {
    /**
     * Atributos
     */
    
        /**
     * Atributo la lista de sprite que contiene las pulgas
     */
    private ArrayList<Element> elements;

    public FoodField() {
        this.elements = new ArrayList<>();
    }
    
    
}
