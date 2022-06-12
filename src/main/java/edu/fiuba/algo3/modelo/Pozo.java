package edu.fiuba.algo3.modelo;

public class Pozo extends Objeto {
    private int penalizacion;

    public Pozo() {
        this.penalizacion = 3;
    }
    public int obtenerPenalizacion() {
        return this.penalizacion;
    }
}
