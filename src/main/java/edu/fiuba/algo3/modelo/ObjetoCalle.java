package edu.fiuba.algo3.modelo;

public abstract class ObjetoCalle {
    public boolean permitePaso(TipoVehiculo unTipo) {
        return true;
    }
    public abstract int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento);

    public void verificarTipo(Vehiculo unVehiculo) {}
}
