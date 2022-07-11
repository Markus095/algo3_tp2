package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaInicio;
import javafx.event.ActionEvent;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import edu.fiuba.algo3.Vista.VistaJuego;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControladorComenzarJuego implements EventHandler<ActionEvent>{
    private Pane controlador;
    private Stage stage;

    private Vehiculo vehiculo;

    private double tamPantalla;
    private VistaInicio vistaInicio;

    public ControladorComenzarJuego(Pane controlador, Stage stage, Vehiculo unVehiculo, double tamPantalla, VistaInicio vistaInicio) {
        this.stage = stage;
        this.controlador = controlador;
        this.vehiculo = unVehiculo;
        this.tamPantalla = tamPantalla;
        this.vistaInicio = vistaInicio;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            new VistaJuego().empezarJuego(stage, controlador, vehiculo, tamPantalla, vistaInicio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
