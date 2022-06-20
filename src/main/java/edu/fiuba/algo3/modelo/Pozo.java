package edu.fiuba.algo3.modelo;

public class Pozo extends ObjetoCalle {
    private int penalizacion;

    public Pozo() {
        this.penalizacion = 3;
    }
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        return unTipo.reaccionarAPozo(movimientos, unMovimiento);
    }

}
