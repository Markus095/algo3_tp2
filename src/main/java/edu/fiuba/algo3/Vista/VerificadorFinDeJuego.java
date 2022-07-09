package edu.fiuba.algo3.Vista;
import edu.fiuba.algo3.controlador.ControladorSalir;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.jugador.Auto;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import edu.fiuba.algo3.modelo.tablero.Posicion;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class VerificadorFinDeJuego {
    private Mapa mapa;
    private Pane contenedor;
    private Botones botones;
    private Stage stage;
    public VerificadorFinDeJuego(Stage stage, Pane contenedorJuego, Mapa unMapa, Botones botones) {
        this.mapa = unMapa;
        this.contenedor = contenedorJuego;
        this.botones = botones;
        this.stage = stage;
    }
    public void verificarFinJuego(Vehiculo vehiculo, int cantidadMovimientos, Grilla grilla) {
        if (mapa.verificarFinDeJuego(vehiculo.obtenerPosicion())) {
            contenedor.getChildren().clear();
            System.gc();
            grilla.actualizar();

            Rectangle rect = new Rectangle(700, 500, Color.WHITE);
            rect.setX(500-350);
            rect.setY(500-250);
            //Label mensaje = new Label("LLEGASTE!! \n\nCantidad de movimientos:" + cantidadMovimientos);
            //mensaje.setFont(new Font("Cambria", 30));
            //mensaje.setTextFill(Color.DARKRED);
            //mensaje.setAlignment(Pos.CENTER);
            botones.deshabilitarBotones(true);


            Button botonSalir = new Button();
            botonSalir.setText("Salir");
            HBox contenedorDeBotones = new HBox(botonSalir);
            contenedorDeBotones.setPadding(new Insets(130));
            contenedorDeBotones.setSpacing(15);
            contenedorDeBotones.setLayoutX(500-350 + 100);
            contenedorDeBotones.setLayoutY(500-350 + 100);

            ControladorSalir controladorSalir = new ControladorSalir(stage);
            botonSalir.setOnAction(controladorSalir);
            vehiculo.reiniciar();
            contenedor.getChildren().addAll(rect, contenedorDeBotones);
        }
    }
}
