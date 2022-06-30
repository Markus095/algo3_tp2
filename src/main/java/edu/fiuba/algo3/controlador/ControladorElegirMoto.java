package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import edu.fiuba.algo3.modelo.jugador.*;
import edu.fiuba.algo3.modelo.entidadesCalle.*;

public class ControladorElegirMoto implements EventHandler<ActionEvent> {
    private Vehiculo vehiculo;
    public ControladorElegirMoto(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        vehiculo.cambioTipoDeVehiculoA(new Moto(new Probabilidad(0.3f)));
    }
}
