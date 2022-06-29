package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.direccion.DireccionDerecha;
import edu.fiuba.algo3.modelo.tablero.Posicion;

public interface TipoVehiculo {

    int reaccionarAPozo( int cantidadDeMovimientos);

    TipoVehiculo cambioVehiculo();

    int reaccionarAPiquete(int cantidadDeMovimientos);


    int reaccionarAControlPolicial(int movimientos);

    Posicion posicionSiguientePostPiquete(Posicion unaPosicion, Direccion unaDireccion);

}
