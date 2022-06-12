package edu.fiuba.algo3.modelo;

public class Pozo extends Objeto {
    private int penalizacion;

    public Pozo() {
        this.penalizacion = 3;
    }
    @Override
    public int obtenerPenalizacion(int movimientos) {
        movimientos += this.penalizacion;
        return movimientos;
    }
}
