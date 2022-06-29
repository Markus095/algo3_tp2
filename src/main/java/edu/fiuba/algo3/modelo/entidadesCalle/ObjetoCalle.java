package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.jugador.Vehiculo;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.tablero.Posicion;

public abstract class ObjetoCalle {

    public abstract int reaccionar(int movimientos, TipoVehiculo unTipo);

    public void verificarTipo(Vehiculo unVehiculo) {}

    public abstract String getNombre();

    public Posicion posicionSiguiente(Posicion unaPosicion, Direccion unaDireccion, TipoVehiculo unTipo) {
        return unaDireccion.obtenerPosicion(unaPosicion);
    }
}