package edu.fiuba.algo3.modelo;

public class Moto extends TipoVehiculo{
    public Moto() {};

    @Override
    public int reaccionarAPozo(int cantidadDeMovimientos, Movimiento unMovimiento) {
        return cantidadDeMovimientos + 3;
    }
    @Override
    public TipoVehiculo cambioVehiculo(){
        return new Auto();
    }

    @Override
    public int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento movimiento) {
        return cantidadDeMovimientos + 2;
    }


}

