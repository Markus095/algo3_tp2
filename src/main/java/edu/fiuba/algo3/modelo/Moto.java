package edu.fiuba.algo3.modelo;

public class Moto implements TipoVehiculo{
    private Probabilidad probaControlPolicial;
    public Moto(Probabilidad unaProbabilidad) {
        this.probaControlPolicial = unaProbabilidad;
    };

    public int reaccionarAPozo(int cantidadDeMovimientos, Movimiento unMovimiento) {
        return cantidadDeMovimientos + 3;
    }

    public TipoVehiculo cambioVehiculo(){
        return new Auto(new Probabilidad(0.5f));
    }

    public int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento movimiento) {
        return cantidadDeMovimientos + 2;
    }

    public int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento) {
        return this.probaControlPolicial.aplicarPenalizacion(movimientos);
    }


}

