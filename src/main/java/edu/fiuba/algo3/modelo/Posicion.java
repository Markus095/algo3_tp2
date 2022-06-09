package edu.fiuba.algo3.modelo;

public abstract class Posicion {
    private int fila;
    private int columna;

    public Posicion(int unaFila, int unaColumna) {
        this.fila = unaFila;
        this.columna = unaColumna;
    }
    public int obtenerFila() {
        return this.fila;
    }
    public int obtenerColumna() {
        return this.columna;
    }
    public boolean equals(Posicion unaPosicion) {
        return (unaPosicion.obtenerFila() == this.fila && unaPosicion.obtenerColumna() == this.columna);
    }

}