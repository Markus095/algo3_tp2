package edu.fiuba.algo3.Vista;
import edu.fiuba.algo3.Main;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class VerificadorFinDeJuego {
    private Mapa mapa;
    private Pane contenedor;
    public VerificadorFinDeJuego(Pane contenedorJuego, Mapa unMapa) {
        this.mapa = unMapa;
        this.contenedor = contenedorJuego;
    }
    public void verificarFinJuego(Posicion posicionVehiculo, int cantidadMovimientos) {
        if (mapa.verificarFinDeJuego(posicionVehiculo)) {
            contenedor.getChildren().clear();
            System.gc();

            Rectangle rect = new Rectangle(0, 0, 1000, 1000);
            rect.setStroke(Color.LIMEGREEN);
            Label mensaje = new Label("FELICITACIONES!! \nCantidad de movimientos:" + cantidadMovimientos);
            mensaje.setFont(new Font("serif", 20));
            mensaje.setTextFill(Color.DARKRED);
            mensaje.setAlignment(Pos.CENTER);
            contenedor.getChildren().addAll(rect, mensaje);
        }
    }
}
