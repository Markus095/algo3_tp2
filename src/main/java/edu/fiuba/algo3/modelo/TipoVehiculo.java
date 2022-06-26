package edu.fiuba.algo3.modelo;

public interface TipoVehiculo {

    int reaccionarAPozo( int cantidadDeMovimientos, Movimiento unMovimiento); //sacar movimiento?

    TipoVehiculo cambioVehiculo();

    int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento movimiento);


    int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento);
}
