package edu.fiuba.algo3.Vista;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;

import java.util.ArrayList;

public class Grilla {
    private ArrayList<Rectangle> calles;
    private Pane contenedor;
    private Rectangle colorFondo;

    public Grilla(Pane contenedor, Color ColorRelleno, Color ColorLinea, double Tam_pantalla, double Ancho, double Alto, double Opacidad, double StrokeWudth, int tamVereda){
        this.calles = new ArrayList<Rectangle>();
        this.contenedor = contenedor;


        //Rectangle colorFondo = new Rectangle(Ancho * TAM_CELDA, Alto*TAM_CELDA);
        Rectangle colorFondo = new Rectangle(Tam_pantalla, Tam_pantalla);

        double tamanio_hor = Tam_pantalla/Ancho;
        double tamanio_ver = Tam_pantalla/Alto;
        System.out.println("tamaniohor"+ tamanio_hor);

        colorFondo.setLayoutX(0);
        colorFondo.setLayoutY(0);
        colorFondo.setFill(ColorRelleno);
        colorFondo.setOpacity(Opacidad);
        this.colorFondo = colorFondo;

        for (int j = 0; j <= Ancho; j+= tamVereda) {
            Rectangle rectangulo = new Rectangle(j * tamanio_hor, 0, tamanio_hor, Tam_pantalla);
            rectangulo.setStroke(ColorLinea);
            rectangulo.setStrokeWidth(StrokeWudth);
            calles.add(rectangulo);
            System.out.println("rectangulo"+ j * tamanio_hor);
        }
        for (int i = 0; i <= Alto; i+= tamVereda) {
            Rectangle rectangulo = new Rectangle(0 , i * tamanio_ver, Tam_pantalla, tamanio_ver);
            rectangulo.setStroke(ColorLinea);
            rectangulo.setStrokeWidth(StrokeWudth);
            calles.add(rectangulo);
        }
        actualizar();
    }

    public void actualizar() {
        contenedor.getChildren().add(colorFondo);

        for (Rectangle rectangulo : calles) {
            contenedor.getChildren().add(rectangulo);
        }
    }
}
