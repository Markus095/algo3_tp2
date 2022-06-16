package edu.fiuba.algo3.modelo;

public class Moto extends TipoVehiculo{
    public Moto() {};

    @Override
    public float reaccionarAPozo(float cantidadDeMovimientos) {
        return cantidadDeMovimientos + 3;
    }
    @Override
    public TipoVehiculo cambioVehiculo(){
        return new Auto();
    }

    @Override
    public float reaccionarAPiquete(float cantidadDeMovimientos) {
        return cantidadDeMovimientos + 2;
    }
}

