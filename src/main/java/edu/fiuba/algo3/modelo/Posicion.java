package edu.fiuba.algo3.modelo;

public class Posicion {
    private int x;
    private int y;

    private Objeto objeto;

    public Posicion(int unaFila, int unaColumna) {
        this.x = unaFila;
        this.y = unaColumna;
        this.objeto = null;
    }

    public int obtenerFila() {
        return this.x;
    }

    public int obtenerColumna() {
        return this.y;
    }

    /* public void guardarObjeto(Objeto unObjeto) {
        this.objeto = unObjeto;
    }

    public Objeto obtenerObjeto() {
        return this.objeto;
    }*/

    public void moverAbajo() {
        this.x ++;
    }

    public void moverArriba() {
        this.x --;
    }

    public void moverIzquierda() {
        this.y --;
    }

    public void moverDerecha() { this.y ++; }

    public boolean esIgual(Posicion otraPosicion){
        return (otraPosicion.obtenerFila() == this.x && otraPosicion.obtenerColumna() == this.y);
    }
}
