package edu.fiuba.algo3.modelo;

public class ObjetoSinPenalizacion extends Objeto{
    int penalizacion;

    public ObjetoSinPenalizacion() {
        this.penalizacion = 0;
    }

    public int obtenerPenalizacion() {
        return this.penalizacion;
    }
}
