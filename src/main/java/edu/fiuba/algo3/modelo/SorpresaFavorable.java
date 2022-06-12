package edu.fiuba.algo3.modelo;

public class SorpresaFavorable extends Objeto {
    private float valor;

    public SorpresaFavorable() {
        this.valor = 0.8f;
    }

    @Override
    public int obtenerPenalizacion(int movimientos) {

        movimientos = (int) (movimientos * this.valor);
        return movimientos;
    }
}
