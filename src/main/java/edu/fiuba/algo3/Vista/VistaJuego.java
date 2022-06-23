package edu.fiuba.algo3.Vista;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.control.Button;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Vehiculo;
import edu.fiuba.algo3.modelo.TipoVehiculo;
import edu.fiuba.algo3.modelo.Auto;
import edu.fiuba.algo3.modelo.Posicion;

public class VistaJuego {
    private Pane contenedorJuego;
    private Stage stage;
    private Vehiculo unVehiculo;
    private Mapa unMapa;

    private Grilla grillaMapa;
    public void empezarJuego(Stage stage, Pane controlador) {
        this.contenedorJuego = controlador;
        this.stage = stage;

        this.unVehiculo = new Vehiculo(new Auto(), new Posicion(0, 0));
        this.unMapa = new Mapa(100, 100);

        unMapa.posicionarVehiculo(unVehiculo);
        unMapa.asignarDestinoFinal(new Posicion(1, 3));

        this.grillaMapa = new Grilla(contenedorJuego, 0 ,0, Color.LIMEGREEN, Color.BLACK, 40, 50,50, 0.8,0.5);

        contenedorJuego.getChildren().clear();
        System.gc();
        actualizarMapaVista();
    }
    private void actualizarMapaVista() {
        grillaMapa.actualizar();
        Posicion posicionVehiculo = unVehiculo.obtenerPosicion();
        /*VistaImagenes.agregarImagen(unVehiculo, "", posicionrelativa, 960, 560,80,true);*/



    }
}
