package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ControladorSalir implements EventHandler<ActionEvent>{
    private Stage stage;
    public ControladorSalir(Stage stage) {
        this.stage = stage;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
    }
}
