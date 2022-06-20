package edu.fiuba.algo3.modelo;

public class Pozo extends Objeto {
    private int penalizacion;

    public Pozo() {
        this.penalizacion = 3;
    }
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Posicion posicionVehiculo ,Direccion unaDireccion, Movimiento unMovimiento) {
        return unTipo.reaccionarAPozo(movimientos, unMovimiento);
    }

}
