package edu.fiuba.algo3.modelo;

public class Auto extends TipoVehiculo{

    public Auto(){};

    public int reaccionarAPozo(int cantidadDeMovimientos, Movimiento unMovimiento) {
        unMovimiento.puedeAvanzar();
        return cantidadDeMovimientos + 3;
    }

    public TipoVehiculo cambioVehiculo(){
        return new CuatroPorCuatro();
    }

    public int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento unMovimiento) {
        unMovimiento.noPuedeAvanzar();
        return cantidadDeMovimientos;
    }

    public int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento) {
        return (new Probabilidad()).aplicarPenalizacionConProbabilidad(0.5f, movimientos);
    }
}
