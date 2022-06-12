package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable extends Objeto{
    private float valor;

    public SorpresaDesfavorable() {
        this.valor = 0.25f;
    }

    @Override
    public int obtenerPenalizacion(int movimientos) {
        movimientos = (int) (movimientos * (this.valor + 1)) + 1;
        return movimientos;
    }
}
