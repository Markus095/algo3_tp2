package edu.fiuba.algo3.modelo.direccion;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public class DireccionDerecha implements Direccion {
    static private DireccionDerecha direccionDerecha = new DireccionDerecha();
    private DireccionDerecha(){}

    static public DireccionDerecha getDireccionDerecha() {
        return direccionDerecha;
    }

    public void mover(Posicion posicion) {
        posicion.moverDerecha();
    }

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionDerecha();
    }
}
