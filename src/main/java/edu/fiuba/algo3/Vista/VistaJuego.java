package edu.fiuba.algo3.Vista;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;

public class VistaJuego {
    private Pane contenedorJuego;
    private Stage stage;

    private Grilla grillaMapa;
    public void empezarJuego(Stage stage, Pane controlador) {
        this.contenedorJuego = controlador;
        this.stage = stage;

        this.grillaMapa = new Grilla(contenedorJuego, 0 ,0, Color.DARKGREEN, Color.BLACK, 80, 23,14, 0.8,0.5);

        contenedorJuego.getChildren().clear();
        System.gc();
        actualizarMapaVista();
    }
    private void actualizarMapaVista() {
        grillaMapa.actualizar();


        /*Collection<Posicionable> tablero = juego.obtenerTodosLosElementos();
        for (Posicionable posicionable : tablero) {
            if (posicionable.getPosicion().estaenRango(juego.getJugador().getPosicion(), 12, 7)) {
                Posicion posicionrelativa = new Posicion(posicionable.getPosicion().getColumna() - juego.getJugador().getPosicion().getColumna(), posicionable.getPosicion().getFila() - juego.getJugador().getPosicion().getFila());
                imagenesVista.agregarView(posicionable, "", posicionrelativa, 960, 560, 80, true);
            }*/

        }
}
