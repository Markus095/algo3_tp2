package edu.fiuba.algo3.modelo;

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
    private Calle buscarCalle(Posicion pos1, Posicion pos2, ArrayList<Calle> calles, Calle calleNoPermitida) {
        // este metodo se puede implementar bien con streams
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return calleNoPermitida;//a corregir
    }

    public Posicion moverseEn(ArrayList<Calle> calles, Direccion unaDireccion, Calle calleNoPermitida) {
        Calle calle = buscarCalle(this.posicionVehiculo, unaDireccion.obtenerPosicion(this.posicionVehiculo), calles, calleNoPermitida);
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

    /*public void setMovimientos(int movimientos) {
        this.cantidadDeMovimientos = movimientos;
    }*/

    public Posicion modificarPosicion(ObjetoCalle unObjeto, Posicion unaPosicion, Direccion unaDireccion) {
        Posicion posicionSiguiente = unObjeto.posicionSiguiente(unaPosicion, unaDireccion, this.tipo);
        return posicionSiguiente;
    }
}
