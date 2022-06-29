package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMoverVehiculoDerecha implements EventHandler<ActionEvent> {
	private VistaJuego juego;
	public ControladorMoverVehiculoDerecha(VistaJuego juego){
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		juego.getMapa().moverVehiculoEn(DireccionDerecha.getDireccionDerecha());
		juego.actualizar();
	}
}
