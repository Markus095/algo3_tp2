package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import edu.fiuba.algo3.Vista.VistaJuego;

import java.util.HashMap;
import java.util.Map;

public class ControladorComenzarJuego implements EventHandler<ActionEvent>{
    private Pane controlador;
    private Stage stage;

    private Vehiculo vehiculo;

    private double tamPantalla;

    public ControladorComenzarJuego(Pane controlador, Stage stage, Vehiculo unVehiculo, double tamPantalla, Map<String, Integer> ranking, String nombreJugador) {
        this.stage = stage;
        this.controlador = controlador;
        this.vehiculo = unVehiculo;
        this.tamPantalla = tamPantalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        new VistaJuego().empezarJuego(stage, controlador, vehiculo, tamPantalla);

    }
}
