package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.tablero.Mapa;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;

public class ControladorBloqueoTeclas implements EventHandler<KeyEvent> {
    private Stage stage;

    public ControladorBloqueoTeclas(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        try {
            if (keyEvent.getCode() == KeyCode.ESCAPE) {
                this.stage.close();
            }
        }catch (Exception e) {
            //Cant move exception
        }
    }
}
