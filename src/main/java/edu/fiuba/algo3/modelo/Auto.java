package edu.fiuba.algo3.modelo;

public class Auto extends TipoVehiculo{

    public Auto(){};


    @Override
    public int reaccionarAPozo(int cantidadDeMovimientos) {
        return cantidadDeMovimientos + 3;
    }
    @Override
    public TipoVehiculo cambioVehiculo(){
        return new CuatroPorCuatro();
    }

    @Override
    public int reaccionarAPiquete(int cantidadDeMovimientos) {
        return cantidadDeMovimientos;
    }
}
