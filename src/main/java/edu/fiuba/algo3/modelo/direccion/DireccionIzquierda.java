package edu.fiuba.algo3.modelo.direccion;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public class DireccionIzquierda implements Direccion {
    static private DireccionIzquierda direccionIzquierda = new DireccionIzquierda();
    private DireccionIzquierda(){}

    static public DireccionIzquierda getDireccionIzquierda() {
        return direccionIzquierda;
    }

    public void mover(Posicion posicion) {
        posicion.moverIzquierda();
    }
    public double obtenerRotacion() {return 270;}

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionIzquierda();
    }
}
