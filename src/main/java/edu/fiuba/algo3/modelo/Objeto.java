package edu.fiuba.algo3.modelo;

public abstract class Objeto {
    public boolean permitePaso(TipoVehiculo unTipo) {
        return true;
    }

    public abstract int reaccionar(int cantidadDeMovimientos, TipoVehiculo unTipo);

    public void verificarTipo(Vehiculo unVehiculo) {}
}
