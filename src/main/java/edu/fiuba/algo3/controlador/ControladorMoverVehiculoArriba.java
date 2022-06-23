package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.Vista.VistaJuego;
import edu.fiuba.algo3.modelo.DireccionArriba;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControladorMoverVehiculoArriba implements EventHandler<ActionEvent> {
		private VistaJuego juego;
		public ControladorMoverVehiculoArriba(VistaJuego juego){
			this.juego = juego;
		}

		@Override
		public void handle(ActionEvent actionEvent) {
			juego.getMapa().moverVehiculoEn(DireccionArriba.getDireccionArriba());
			juego.actualizar();
		}
	}
