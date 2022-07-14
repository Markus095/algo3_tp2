package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.tablero.Mapa;
import javafx.stage.Stage;

public class ControladorEscape implements ControladorTecla{
    public void accionar(Stage stage, Mapa mapa) {
        stage.close();
    }
}