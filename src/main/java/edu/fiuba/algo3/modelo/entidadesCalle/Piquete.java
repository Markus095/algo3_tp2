package edu.fiuba.algo3.modelo.entidadesCalle;

import edu.fiuba.algo3.modelo.jugador.TipoVehiculo;
import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.tablero.Posicion;

public class Piquete extends ObjetoCalle {


    public Piquete() {
}
    public String getNombre() {return "piquete";}
    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return unTipo.reaccionarAPiquete(movimientos);
    }

    @Override
    public Posicion posicionSiguiente(Posicion unaPosicion, Direccion unaDireccion, TipoVehiculo unTipo) {
        return unTipo.posicionSiguiente(unaPosicion, unaDireccion);
    }

}


