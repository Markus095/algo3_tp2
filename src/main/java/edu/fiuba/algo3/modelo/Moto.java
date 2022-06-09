package edu.fiuba.algo3.modelo;

public class Moto {
    private Posicion posicionVehiculo;

    public Moto(Posicion unaPosicion) {
        this.posicionVehiculo = unaPosicion;
    }
    public Posicion obtenerPosicion() {
        return this.posicionVehiculo;
    }
    public void moverA(Posicion unaPosicion) {
        this.posicionVehiculo = unaPosicion;
    }

}