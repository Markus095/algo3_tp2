package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.direccion.DireccionAbajo;
import edu.fiuba.algo3.modelo.direccion.DireccionArriba;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.direccion.DireccionIzquierda;
import edu.fiuba.algo3.modelo.tablero.Mapa;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.HashMap;

public class ControladorDeBotones implements EventHandler<KeyEvent> {

    private Mapa mapa;
    private Stage stage;
    private HashMap<KeyCode, ControladorTecla> mapaTeclas = new HashMap<>();


    public ControladorDeBotones(Mapa mapa, Stage stage) {
        this.stage = stage;
        this.mapa = mapa;
        this.mapaTeclas.put(KeyCode.ESCAPE, new ControladorEscape());
        this.mapaTeclas.put(KeyCode.W, new ControladorMoverArriba());
        this.mapaTeclas.put(KeyCode.A, new ControladorMoverIzquierda());
        this.mapaTeclas.put(KeyCode.S, new ControladorMoverAbajo());
        this.mapaTeclas.put(KeyCode.D, new ControladorMoverDerecha());

        this.mapaTeclas.put(KeyCode.UP, new ControladorMoverArriba());
        this.mapaTeclas.put(KeyCode.LEFT, new ControladorMoverIzquierda());
        this.mapaTeclas.put(KeyCode.DOWN, new ControladorMoverAbajo());
        this.mapaTeclas.put(KeyCode.RIGHT, new ControladorMoverDerecha());
    }

    @Override

    public void handle(KeyEvent event) {
        ControladorTecla controladorTecla = mapaTeclas.get(event.getCode());
        try {
            controladorTecla.accionar(stage, mapa);
        }catch (Exception e) {

        }

        event.consume();
    }
}