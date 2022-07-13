package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.patronObserver.Observer;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class VistaVehiculo implements Observer{
    private VistaMapa stage;
    private Vehiculo vehiculo;

    public VistaVehiculo(VistaMapa vistaMapa, Vehiculo unVehiculo) {
        this.stage = vistaMapa;
        this.vehiculo = unVehiculo;

        vehiculo.agregarObservador(this);
        stage.addViewOnMap(vehiculo.obtenerNombreTipo(), vehiculo.obtenerPosicion(), vehiculo.obtenerPosicionAnterior());

    }

    public void actualizar() {
        stage.addViewOnMap(vehiculo.obtenerNombreTipo(), vehiculo.obtenerPosicion(), vehiculo.obtenerPosicionAnterior());
    }

}
