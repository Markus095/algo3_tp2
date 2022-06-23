package edu.fiuba.algo3.Vista;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;

public class Grilla {

    private ArrayList<Line> lineas;
    private ArrayList<Rectangle> calles;
    private Pane contenedor;
    private Rectangle relleno;

    public Grilla(Pane contenedor, int PosX, int PosY, Color ColorRelleno, Color ColorLinea, int TAM_CELDA, int Ancho, int Alto, double Opacidad, double StrokeWudth){
        this.lineas = new ArrayList<Line>();
        this.calles = new ArrayList<Rectangle>();
        this.contenedor = contenedor;

        Rectangle relleno = new Rectangle(TAM_CELDA * (Ancho+1), TAM_CELDA *(Alto+1));
        relleno.setLayoutX(PosX);
        relleno.setLayoutY(PosY);
        relleno.setFill(ColorRelleno);
        relleno.setOpacity(Opacidad);
        this.relleno = relleno;

        for (int j = 0; j <= Ancho + 1; j+=4) {
            Rectangle rectangulo = new Rectangle(PosX + j * TAM_CELDA, 0, TAM_CELDA, TAM_CELDA*(Alto + 1));
            rectangulo.setStroke(ColorLinea);
            rectangulo.setStrokeWidth(StrokeWudth);
            calles.add(rectangulo);
        }
        for (int i = 0; i <= Alto + 1; i+=4) {
            Rectangle rectangulo = new Rectangle(0 , PosY + i * TAM_CELDA, TAM_CELDA*(Ancho + 1), TAM_CELDA);
            rectangulo.setStroke(ColorLinea);
            rectangulo.setStrokeWidth(StrokeWudth);
            calles.add(rectangulo);
        }

        actualizar();
    }

    public void actualizar() {
        contenedor.getChildren().add(relleno);
        for (Rectangle rectangulo : calles) { contenedor.getChildren().add(rectangulo); }
    }
}
