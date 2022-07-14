package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoCalle;
import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.tablero.Posicion;

import java.io.IOException;
import java.util.ArrayList;

public interface Observer {
    void actualizar(Posicion posicion, TipoVehiculo tipoVehiculo, int cantidadMovimientos, Direccion direccion, ArrayList<ObjetoCalle> objetosLevantados) throws IOException;
}
