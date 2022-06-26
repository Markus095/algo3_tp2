package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import edu.fiuba.algo3.Vista.VistaJuego;

public class ControladorComenzarJuego implements EventHandler<ActionEvent>{
    private Pane controlador;
    private Stage stage;

    public ControladorComenzarJuego(Pane controlador, Stage stage) {
        this.stage = stage;
        this.controlador = controlador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        new VistaJuego().empezarJuego(stage, controlador);

    }
}
