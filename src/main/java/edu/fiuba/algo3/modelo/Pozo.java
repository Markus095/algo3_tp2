package edu.fiuba.algo3.modelo;

public class Pozo extends ObjetoCalle {

    public Pozo() {}

    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        return unTipo.reaccionarAPozo(movimientos, unMovimiento);
    }

}
