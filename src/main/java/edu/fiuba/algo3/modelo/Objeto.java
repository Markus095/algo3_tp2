package edu.fiuba.algo3.modelo;

public abstract class Objeto {
    public boolean permitePaso(TipoVehiculo unTipo) {
        return true;
    }

    public abstract int reaccionar(int movimientos, TipoVehiculo unTipo, Posicion posicionVehiculo ,Direccion unaDireccion, Movimiento unMovimiento);

    public void verificarTipo(Vehiculo unVehiculo) {}
}
