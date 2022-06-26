package edu.fiuba.algo3.modelo;

public class DireccionArriba implements Direccion {

    static private DireccionArriba direccionArriba = new DireccionArriba();
    private DireccionArriba(){}

    static public DireccionArriba getDireccionArriba() {
        return direccionArriba;
    }

    public void mover(Posicion posicion) {
        posicion.moverArriba();
    }

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionArriba();
    }

}
