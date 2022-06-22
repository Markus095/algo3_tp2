package edu.fiuba.algo3.modelo;

public abstract class TipoVehiculo {

    public abstract int reaccionarAPozo( int cantidadDeMovimientos, Movimiento unMovimiento); //sacar movimiento?

    public int reaccionarASorpresaFavorable(int cantidadDeMovimientos){

        return Math.round(cantidadDeMovimientos * 0.8f);
    };

    public int reaccionarASorpresaDesfavorable(int cantidadDeMovimientos){

        return Math.round(cantidadDeMovimientos * 1.25f);
    };

    public abstract TipoVehiculo cambioVehiculo();

    public abstract int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento movimiento);


    public abstract int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento);
}
