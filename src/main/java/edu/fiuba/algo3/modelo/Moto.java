package edu.fiuba.algo3.modelo;

public class Moto extends TipoVehiculo{
    public Moto() {};

    @Override
    public int reaccionarAPozo(int cantidadDeMovimientos) {
        return cantidadDeMovimientos + 3;
    }
    @Override
    public TipoVehiculo cambioVehiculo(){
        return new Auto();
    }

    @Override
    public int reaccionarAPiquete(int cantidadDeMovimientos) {
        return cantidadDeMovimientos + 2;
    }

    @Override
    public boolean avanzo() {
        return false;
    }
}

