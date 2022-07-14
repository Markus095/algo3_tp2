package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class ControladorSalir implements EventHandler<ActionEvent> {
    private Stage stage;
    public ControladorSalir(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent action){
        stage.close();
    }
}
