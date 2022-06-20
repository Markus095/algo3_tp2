package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable extends ObjetoCalle {
    private float valor;

    public SorpresaDesfavorable() {
        this.valor = 0.25f;
    }

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        return unTipo.reaccionarASorpresaDesfavorable(movimientos);
    }
}
