package edu.fiuba.algo3.modelo;

public class Moto implements TipoVehiculo{
    public Moto() {};

    public int reaccionarAPozo(int cantidadDeMovimientos, Movimiento unMovimiento) {
        return cantidadDeMovimientos + 3;
    }

    public TipoVehiculo cambioVehiculo(){
        return new Auto();
    }

    public int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento movimiento) {
        return cantidadDeMovimientos + 2;
    }

    public int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento) {
        return (new Probabilidad()).aplicarPenalizacionConProbabilidad(0.8f, movimientos);
    }


}

