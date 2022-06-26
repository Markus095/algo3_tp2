package edu.fiuba.algo3.modelo;

public class DireccionAbajo implements Direccion {
    static private DireccionAbajo direccionAbajo = new DireccionAbajo();
    private DireccionAbajo(){}

    static public DireccionAbajo getDireccionAbajo() {
        return direccionAbajo;
    }

    public void mover(Posicion posicion) {
        posicion.moverAbajo();
    }

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionAbajo();
    }
}
