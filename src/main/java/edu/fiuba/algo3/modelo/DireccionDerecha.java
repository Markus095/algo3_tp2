package edu.fiuba.algo3.modelo;

public class DireccionDerecha extends Direccion {
    static private DireccionDerecha direccionDerecha = new DireccionDerecha();
    private DireccionDerecha(){}

    static public DireccionDerecha getDireccionDerecha() {
        return direccionDerecha;
    }
    @Override
    public void mover(Posicion posicion) {
        posicion.moverDerecha();
    }

    public Posicion obtenerPosicion(Posicion posicion) {
        return posicion.obtenerPosicionDerecha();
    }
}
