package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.direccion.DireccionIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.IOException;


public class ControladorMoverVehiculoIzquierda implements EventHandler<ActionEvent> {
	private VistaJuego juego;
	public ControladorMoverVehiculoIzquierda(VistaJuego juego){
		this.juego = juego;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		juego.getMapa().moverVehiculoEn(DireccionIzquierda.getDireccionIzquierda());
		try {
			juego.actualizar(DireccionIzquierda.getDireccionIzquierda());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
