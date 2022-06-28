package edu.fiuba.algo3.modelo;

public abstract class ObjetoCalle {

    public abstract int reaccionar(int movimientos, TipoVehiculo unTipo);

    public void verificarTipo(Vehiculo unVehiculo) {}

    public abstract String getNombre();

    public Posicion posicionSiguiente(Posicion unaPosicion, Direccion unaDireccion, TipoVehiculo unTipo) {
        return unaDireccion.obtenerPosicion(unaPosicion);
    }
}
