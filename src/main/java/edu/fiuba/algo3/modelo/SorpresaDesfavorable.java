package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable extends ObjetoCalle {
    private float valor;

    public SorpresaDesfavorable() {
        this.valor = 1.25f;
    }

    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        return Math.round(this.valor * movimientos);
    }
}
