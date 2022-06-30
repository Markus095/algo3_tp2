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
    private Posicion posicionLlegada;
    public RangoVision(Pane contenedorJuego, double tamPantalla, float tamanio, Posicion posVehiculo, Posicion posicionLlegada) {
        this.tamPantalla = tamPantalla;
        this.tamanio = tamanio;
        this.contenedor = contenedorJuego;
        this.posicionLlegada = posicionLlegada;

        Rectangle rect = new Rectangle(0, 0, tamPantalla, tamPantalla);
        Circle circ = new Circle(posVehiculo.obtenerColumna() * tamanio * 4 + tamanio/2, posVehiculo.obtenerFila() * tamanio * 4 + tamanio/2, tamanio * 20);
        Shape clip = Shape.subtract(rect, circ);
        Circle cirLlegada = new Circle(posicionLlegada.obtenerColumna() * tamanio * 4 + tamanio/2, posicionLlegada.obtenerFila() * tamanio * 4 + tamanio/2, tamanio/2);
        Shape clip2 = Shape.subtract(clip, cirLlegada);
        contenedorJuego.getChildren().add(clip2);
    }
    public void actualizarRangoVision(Posicion posVehiculo) {
        Rectangle rect = new Rectangle(0, 0, tamPantalla, tamPantalla);
        Circle circ = new Circle(posVehiculo.obtenerColumna() * tamanio * 4 + tamanio/2, posVehiculo.obtenerFila() * tamanio * 4 + tamanio/2, tamanio * 9);
        Shape clip = Shape.subtract(rect, circ);
        Circle cirLlegada = new Circle(posicionLlegada.obtenerColumna() * tamanio * 4 + tamanio/2, posicionLlegada.obtenerFila() * tamanio * 4 + tamanio/2, tamanio/2);
        Shape clip2 = Shape.subtract(clip, cirLlegada);

        contenedor.getChildren().add(clip2);
    }
}
