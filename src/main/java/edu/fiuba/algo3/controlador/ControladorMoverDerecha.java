package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import javafx.stage.Stage;

public class ControladorMoverDerecha implements ControladorTecla{
    public void accionar(Stage stage, Mapa mapa) {
        mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
    }
}