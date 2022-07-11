package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.direccion.DireccionAbajo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;


public class ControladorMoverVehiculoAbajo implements EventHandler<ActionEvent> {
	private VistaJuego juego;
	public ControladorMoverVehiculoAbajo(VistaJuego juego){
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		juego.getMapa().moverVehiculoEn(DireccionAbajo.getDireccionAbajo());
		try {
			juego.actualizar();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}

