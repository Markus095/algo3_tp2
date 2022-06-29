package edu.fiuba.algo3.modelo;

public class NoPermitirPaso extends ObjetoCalle {

    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return 0;
    }

    public String getNombre() {
        return null;
    }
    @Override
    public Posicion posicionSiguiente(Posicion unaPosicion, Direccion unaDireccion, TipoVehiculo unTipo) {
        return unaPosicion;
    }
}
