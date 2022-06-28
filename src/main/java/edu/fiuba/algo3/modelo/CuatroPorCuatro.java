package edu.fiuba.algo3.modelo;

public class CuatroPorCuatro implements TipoVehiculo {
    private int cantidadPozos;
    private Probabilidad probaControlPolicial;
    public CuatroPorCuatro(Probabilidad unaProba) {
        this.cantidadPozos = 0;
        this.probaControlPolicial = unaProba;
    }

    public int reaccionarAPozo(int cantidadDeMovimientos) {
        this.cantidadPozos ++;
        if (this.cantidadPozos >=  3) {
            return cantidadDeMovimientos + 2;
        }
        return cantidadDeMovimientos;
    }

    public TipoVehiculo cambioVehiculo(){ return new Moto(new Probabilidad(0.8f)); }

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
