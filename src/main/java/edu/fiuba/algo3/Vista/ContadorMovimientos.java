package edu.fiuba.algo3.Vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.scene.paint.Color;

public class ContadorMovimientos {
    private Pane contenedor;
    private HBox checkUpdatesBar;

    private Rectangle rectangle;
    private Text text;

    private VBox flow;
    private Font fontTitulo;
    private Font fontSubTitulo;
    private Label movimientos;

    public ContadorMovimientos(Pane contenedorJuego, int cantidadMovimientos) {
        contenedor = contenedorJuego;
        rectangle = new Rectangle(280,30, Color.WHITE);
        movimientos = new Label("Cantidad de movimientos:" + cantidadMovimientos);
        movimientos.setFont(new Font("serif", 16));
        movimientos.setTextFill(Color.BLACK);
        movimientos.setLayoutX((contenedorJuego.getWidth()) - (rectangle.getWidth())*0.98);
        movimientos.setLayoutY((contenedorJuego.getHeight()) - (rectangle.getHeight())*0.98);

        rectangle.setX((contenedorJuego.getWidth()) - (rectangle.getWidth()));
        rectangle.setY((contenedorJuego.getHeight()) - (rectangle.getHeight()));
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        rectangle.setOpacity(0.4);
        contenedor.getChildren().addAll(rectangle, movimientos);
    }

    public void actualizar(int cantidadMovimientos) {
        movimientos = new Label("Cantidad de movimientos:" + cantidadMovimientos);
        movimientos.setLayoutX((contenedor.getWidth()) - (rectangle.getWidth())*0.98);
        movimientos.setLayoutY((contenedor.getHeight()) - (rectangle.getHeight())*0.98);

        rectangle.setX((contenedor.getWidth()) - (rectangle.getWidth()));
        rectangle.setY((contenedor.getHeight()) - (rectangle.getHeight()));
        rectangle.setArcWidth(20);
        rectangle.setArcHeight(20);
        rectangle.setOpacity(0.4);
        contenedor.getChildren().addAll(rectangle, movimientos);
    }
}
