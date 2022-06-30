package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ControladorElegirAuto implements EventHandler<ActionEvent> {
    private Vehiculo vehiculo;
    public ControladorElegirAuto(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        vehiculo.cambioTipoDeVehiculoA(new Auto(new Probabilidad(0.3f)));
    }
}
