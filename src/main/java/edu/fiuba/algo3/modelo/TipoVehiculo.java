package edu.fiuba.algo3.modelo;

public interface TipoVehiculo {

    int reaccionarAPozo( int cantidadDeMovimientos);

    TipoVehiculo cambioVehiculo();

    int reaccionarAPiquete(int cantidadDeMovimientos);


    int reaccionarAControlPolicial(int movimientos);

    Posicion posicionSiguiente(Posicion unaPosicion, Direccion unaDireccion);
}
