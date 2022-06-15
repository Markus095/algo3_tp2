package edu.fiuba.algo3.modelo;

public class CuatroPorCuatro extends TipoVehiculo {
    private int cantidadPozos;
    public CuatroPorCuatro() {
        this.cantidadPozos = 0;
    }

    @Override
    public float reaccionarAPozo(float cantidadDeMovimientos) {
        this.cantidadPozos ++;
        if (this.cantidadPozos >=  3) {
            return cantidadDeMovimientos + 2;
        }
        return cantidadDeMovimientos;
    }
    @Override
    public TipoVehiculo cambioVehiculo(){
        return new Moto();
    }
}
