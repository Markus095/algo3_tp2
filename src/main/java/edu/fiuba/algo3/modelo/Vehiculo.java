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


    public void modificarMovimientos(Objeto unObjeto) {
        this.cantidadDeMovimientos = unObjeto.reaccionar(this.cantidadDeMovimientos, this.tipo);

    }

    public float obtenerCantidadMovimientos() {
        return this.cantidadDeMovimientos;
    }


    public void moverAbajo() {
        this.posicionVehiculo.moverAbajo();
        this.cantidadDeMovimientos++;
    }

    public void moverArriba() {
        this.posicionVehiculo.moverArriba();
        this.cantidadDeMovimientos++;
    }

    public void moverIzquierda() {
        this.posicionVehiculo.moverIzquierda();
        this.cantidadDeMovimientos++;
    }

    public void moverDerecha() {
        this.posicionVehiculo.moverDerecha();
        this.cantidadDeMovimientos++;
    }

    public TipoVehiculo obtenerTipo() {
        return this.tipo;
    }

    public void cambioTipoDeVehiculo() {
        this.tipo = this.tipo.cambioVehiculo();
    }

    public boolean puedeAvanzar(Objeto unObjeto) {
        return unObjeto.permitePaso(this.tipo);
    }
}
