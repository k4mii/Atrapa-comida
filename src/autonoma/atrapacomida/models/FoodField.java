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

    /**
     * crear un nuevo objeto Elemento randomX() : posicion inicial en X (columna
     * aleatoria donde va a aparecer el elemento cayendo). 0 : posicion inicial
     * en Y (siempre arriba del todo). GestorSprites.comida: aquí se está
     * pasando una imagen o sprite que viene de una clase llamada GestorSprites.
     * Eso sería una imagen que ya ha sido cargada antes "comida" : tipo de
     * elemento, en forma de String, para que luego en el juego puedas
     * identificar si es comida o veneno cuando se atrapa o dibuja.
     */
    public void agregarComida() {
        Element comida = new Element(
                randomX(),
                0,
                GestorSprites.eat, // Aquí usa la imagen de GestorSprites
                "comida"
        );
        elements.add(comida);
    }

    public void agregarVeneno() {
        Element veneno = new Element(
                randomX(),
                0,
                GestorSprites.pocion,
                "veneno"
        );
        elements.add(veneno);
    }

    public ArrayList<Element> getElementos() {
        return elements;
    }

}
