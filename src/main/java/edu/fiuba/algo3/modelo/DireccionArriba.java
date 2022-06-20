package edu.fiuba.algo3.modelo;

public class DireccionArriba extends Direccion {

    static private DireccionArriba direccionArriba = new DireccionArriba();
    private DireccionArriba(){}

    static public DireccionArriba getDireccionArriba() {
        return direccionArriba;
    }
    @Override
    public void mover(Posicion posicion) {
        posicion.moverArriba();
    }

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionArriba();
    }

}
