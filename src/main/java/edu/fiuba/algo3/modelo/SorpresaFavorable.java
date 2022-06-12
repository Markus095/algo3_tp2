package edu.fiuba.algo3.modelo;

public class SorpresaFavorable extends Objeto {
    private float valor;

    public SorpresaFavorable() {
        this.valor = 0.2f;
    }


    public int obtenerPenalizacion(int movimientos) {
        return (int) (movimientos * this.valor);
    }
}
