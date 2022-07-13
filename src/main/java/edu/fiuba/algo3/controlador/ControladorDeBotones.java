package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaVehiculo;
import edu.fiuba.algo3.modelo.direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ControladorDeBotones implements EventHandler<KeyEvent> {

    private Mapa mapa;


    public ControladorDeBotones(Mapa mapa) {
        this.mapa = mapa;
    }

    @Override
    public void handle(KeyEvent event) {
        try {
            if (event.getCode() == KeyCode.W) {
                mapa.moverVehiculoEn(DireccionArriba.getDireccionArriba());
            }
            if (event.getCode() == KeyCode.S) {
                mapa.moverVehiculoEn(DireccionAbajo.getDireccionAbajo());
            }
            if (event.getCode() == KeyCode.D) {
                mapa.moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
            }
            if (event.getCode() == KeyCode.A) {
                mapa.moverVehiculoEn(DireccionIzquierda.getDireccionIzquierda());
            }
            event.consume();
        } catch (Exception e) {
            //Cant move exception
        }
    }
}
