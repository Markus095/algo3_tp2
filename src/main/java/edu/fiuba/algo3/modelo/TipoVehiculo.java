package edu.fiuba.algo3.modelo;

public abstract class TipoVehiculo {

    public abstract int reaccionarAPozo( int cantidadDeMovimientos, Movimiento unMovimiento); //sacar movimiento?

    public abstract TipoVehiculo cambioVehiculo();

    public abstract int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento movimiento);


    public abstract int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento);
}
