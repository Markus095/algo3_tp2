package edu.fiuba.algo3.modelo;

public class Movimiento {
    private boolean sePermiteAvanzar = true;
    private Posicion posicionVehiculo;
    private Direccion direccion;
    public Movimiento(Posicion unaPosicionVehiculo, Direccion unaDireccion) {
        this.posicionVehiculo = unaPosicionVehiculo;
        this.direccion = unaDireccion;
    }

    public void puedeAvanzar() {}//no se si es necesario
    public void noPuedeAvanzar() {
        this.sePermiteAvanzar = false;
    }

    public void moverVehiculo() {
        if (this.sePermiteAvanzar) {
            this.direccion.mover(this.posicionVehiculo);
        }
    }
}
