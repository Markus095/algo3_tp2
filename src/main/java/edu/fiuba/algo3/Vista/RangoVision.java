package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class RangoVision {
    private double tamPantalla;
    private float tamanio;
    private Pane contenedor;
    public RangoVision(Pane contenedorJuego, double tamPantalla, float tamanio, Posicion posVehiculo) {
        this.tamPantalla = tamPantalla;
        this.tamanio = tamanio;
        this.contenedor = contenedorJuego;

        Rectangle rect = new Rectangle(0, 0, tamPantalla, tamPantalla);
        Circle circ = new Circle(posVehiculo.obtenerFila() * tamanio * 4, posVehiculo.obtenerColumna() * tamanio * 4, tamanio * 20);
        Shape clip = Shape.subtract(rect, circ);

        contenedorJuego.getChildren().add(clip);
    }
    public void actualizarRangoVision(Posicion posVehiculo) {
        Rectangle rect = new Rectangle(0, 0, tamPantalla, tamPantalla);
        Circle circ = new Circle(posVehiculo.obtenerColumna() * tamanio * 4, posVehiculo.obtenerFila() * tamanio * 4, tamanio * 9);
        Shape clip = Shape.subtract(rect, circ);

        contenedor.getChildren().add(clip);
    }
}
