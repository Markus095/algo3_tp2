package edu.fiuba.algo3.modelo;

public class CuatroPorCuatro implements TipoVehiculo {
    private int cantidadPozos;
    public CuatroPorCuatro() {
        this.cantidadPozos = 0;
    }

    public int reaccionarAPozo(int cantidadDeMovimientos, Movimiento unMovimiento) {
        this.cantidadPozos ++;
        if (this.cantidadPozos >=  3) {
            return cantidadDeMovimientos + 2;
        }
        return cantidadDeMovimientos;
    }

    public TipoVehiculo cambioVehiculo(){
        return new Moto();
    }

    public int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento unMovimiento) {
        unMovimiento.noPuedeAvanzar();
        return cantidadDeMovimientos;
    }

    public int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento) {
        return (new Probabilidad()).aplicarPenalizacionConProbabilidad(0.3f, movimientos);
    }
}
