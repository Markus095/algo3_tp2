package edu.fiuba.algo3.modelo.jugador;

import edu.fiuba.algo3.modelo.direccion.Direccion;
import edu.fiuba.algo3.modelo.entidadesCalle.ObjetoCalle;
import edu.fiuba.algo3.modelo.entidadesCalle.Probabilidad;
import edu.fiuba.algo3.modelo.tablero.BuscadorCalle;
import edu.fiuba.algo3.modelo.tablero.Calle;
import edu.fiuba.algo3.modelo.tablero.Posicion;

import java.util.ArrayList;

public class Vehiculo {
    private Posicion posicionVehiculo;
    protected int cantidadDeMovimientos;
    private TipoVehiculo tipo;

    public Vehiculo(TipoVehiculo unTipo, Posicion unaPosicion) {
        this.posicionVehiculo = unaPosicion;
        this.cantidadDeMovimientos = 0;
        this.tipo = unTipo;
    }

    public Posicion obtenerPosicion() {
        return this.posicionVehiculo;
    }

    public void modificarMovimientos(ObjetoCalle unObjetoCalle) {
        this.cantidadDeMovimientos = unObjetoCalle.reaccionar(this.cantidadDeMovimientos, this.tipo);
    }

    public float obtenerCantidadMovimientos() {
        return this.cantidadDeMovimientos;
    }

    public Posicion moverseEn(ArrayList<Calle> calles, Direccion unaDireccion) {
        BuscadorCalle buscador = new BuscadorCalle();
        Calle calle = buscador.buscarCalle(calles, this.posicionVehiculo, unaDireccion.obtenerPosicion(this.posicionVehiculo));
        this.posicionVehiculo = calle.aplicarPenalizacion(this, unaDireccion, this.posicionVehiculo);
        this.cantidadDeMovimientos++;
        return this.posicionVehiculo;
    }

    public TipoVehiculo obtenerTipo() {
        return this.tipo;
    }

    public void cambioTipoDeVehiculo() {
        this.tipo = this.tipo.cambioVehiculo();
    }

    public boolean verificarPosicionFinDeJuego(Posicion posicionDestino) {
        return(this.posicionVehiculo.esIgual(posicionDestino));
    }
    public void cambioTipoDeVehiculoA(TipoVehiculo unTipo) {
        this.tipo = unTipo;
    }

    /*public void setMovimientos(int movimientos) {
        this.cantidadDeMovimientos = movimientos;
    }*/

    public Posicion modificarPosicion(ObjetoCalle unObjeto, Posicion unaPosicion, Direccion unaDireccion) {
        Posicion posicionSiguiente = unObjeto.posicionSiguiente(unaPosicion, unaDireccion, this.tipo);
        return posicionSiguiente;
    }

}
