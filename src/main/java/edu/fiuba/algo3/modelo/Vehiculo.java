package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Vehiculo {
    private Posicion posicionVehiculo;
    private Posicion posicionDestino;
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

    public void modificarMovimientos(ObjetoCalle unObjetoCalle, Direccion unaDireccion, Movimiento movimiento) {
        this.cantidadDeMovimientos = unObjetoCalle.reaccionar(this.cantidadDeMovimientos, this.tipo, movimiento);
    }

    public float obtenerCantidadMovimientos() {
        return this.cantidadDeMovimientos;
    }
    private Calle buscarCalle(Posicion pos1, Posicion pos2, ArrayList<Calle> calles) {
        // este metodo se puede implementar bien con streams
        for (Calle calle : calles) {
            if (calle.vaDesdeHasta(pos1, pos2) || calle.vaDesdeHasta(pos2,pos1)) return calle;
        }
        return new Calle(pos1,pos2);//a corregir
    }

    public void moverseEn(ArrayList<Calle> calles, Direccion unaDireccion) {
        Calle calle = buscarCalle(this.posicionVehiculo, unaDireccion.obtenerPosicion(this.posicionVehiculo), calles);
        calle.aplicarPenalizacion(this, unaDireccion, this.posicionVehiculo);
        this.cantidadDeMovimientos++;
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

    public void setMovimientos(int movimientos) {
        this.cantidadDeMovimientos = movimientos;
    }
}
