package edu.fiuba.algo3;

<<<<<<< Updated upstream
public class Main {
    public static void main(String[] args) {
        App.main(args);
=======
import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.Vista.VistaMapa;
import edu.fiuba.algo3.Vista.VistaVehiculo;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.tablero.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.controlador.ControladorComenzarJuego;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.net.PortUnreachableException;
import java.util.Map;
import java.util.HashMap;

public class Main extends Application {
    private VistaVehiculo vistaVehiculo;
    private VistaMapa vistaMapa;
    private Pane contenedorJuego;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("GPS CHALLENGE");
        Vehiculo vehiculo = new Vehiculo(new Moto(new Probabilidad(0.8f)), new Posicion(3,3));
        Mapa mapa = new Mapa(11, 11);
        mapa.inicializar();
        mapa.posicionarVehiculo(vehiculo);
        Posicion destinoFinal = new Posicion(3, 5);
        mapa.asignarDestinoFinal(destinoFinal);
        vistaMapa = new VistaMapa(mapa, destinoFinal);

        vistaVehiculo = new VistaVehiculo(vistaMapa, vehiculo);

        mapa.agregarObservador(vistaVehiculo);

        contenedorJuego = vistaMapa.inicializarVistaMapa();

        Scene theScene = new Scene(contenedorJuego);
        theScene.setOnKeyPressed(new ControladorDeBotones(mapa));
        primaryStage.setScene(theScene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setWidth(1000);
        primaryStage.setHeight(1000);
        primaryStage.show();
>>>>>>> Stashed changes
    }
}
