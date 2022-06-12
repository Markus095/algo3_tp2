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

    public void moverDerecha() {
        this.y = this.y + 2;
    }

    public void guardarObjeto(Objeto unObjeto) {
        this.objeto = unObjeto;
    }

    public Objeto obtenerObjeto() {
        return this.objeto;
    }
}