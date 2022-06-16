package edu.fiuba.algo3.modelo;

public class Auto extends TipoVehiculo{

    public Auto(){};


    @Override
    public float reaccionarAPozo(float cantidadDeMovimientos) {
        return cantidadDeMovimientos + 3;
    }
    @Override
    public TipoVehiculo cambioVehiculo(){
        return new CuatroPorCuatro();
    }

    @Override
    public float reaccionarAPiquete(float cantidadDeMovimientos) {
        return cantidadDeMovimientos;
    }
}
