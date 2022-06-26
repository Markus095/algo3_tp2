package edu.fiuba.algo3.modelo;

public class Auto implements TipoVehiculo{
    private Probabilidad probaControlPolicial;
    public Auto(Probabilidad unaProbabilidad){
        this.probaControlPolicial = unaProbabilidad;
    };

    public int reaccionarAPozo(int cantidadDeMovimientos, Movimiento unMovimiento) {
        unMovimiento.puedeAvanzar();
        return cantidadDeMovimientos + 3;
    }

    public TipoVehiculo cambioVehiculo(){
        return new CuatroPorCuatro(new Probabilidad(0.3f));
    }

    public int reaccionarAPiquete(int cantidadDeMovimientos, Movimiento unMovimiento) {
        unMovimiento.noPuedeAvanzar();
        return cantidadDeMovimientos;
    }

    public int reaccionarAControlPolicial(int movimientos, Movimiento unMovimiento) {
        return this.probaControlPolicial.aplicarPenalizacion(movimientos);
    }
}
