package edu.fiuba.algo3.modelo.direccion;

import edu.fiuba.algo3.modelo.tablero.Posicion;

public class DireccionArriba implements Direccion {

    static private DireccionArriba direccionArriba = new DireccionArriba();
    private DireccionArriba(){}

    static public DireccionArriba getDireccionArriba() {
        return direccionArriba;
    }

    public double obtenerRotacion() {return 0;}

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionArriba();
    }

}
