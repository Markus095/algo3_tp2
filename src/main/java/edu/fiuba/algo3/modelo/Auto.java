package edu.fiuba.algo3.modelo;

public class Auto implements TipoVehiculo{
    private Probabilidad probaControlPolicial;
    public Auto(Probabilidad unaProbabilidad){
        this.probaControlPolicial = unaProbabilidad;
    };

    public int reaccionarAPozo(int cantidadDeMovimientos) {
        return cantidadDeMovimientos + 3;
    }

    public TipoVehiculo cambioVehiculo(){
        return new CuatroPorCuatro(new Probabilidad(0.3f));
    }

    public int reaccionarAPiquete(int cantidadDeMovimientos) {
        return cantidadDeMovimientos;
    }

    public int reaccionarAControlPolicial(int movimientos) {
        return this.probaControlPolicial.aplicarPenalizacion(movimientos);
    }

    public Posicion posicionSiguiente(Posicion unaPosicion, Direccion unaDireccion) {
        return unaPosicion;
    }
}
