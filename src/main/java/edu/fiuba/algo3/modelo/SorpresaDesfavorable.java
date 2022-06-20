package edu.fiuba.algo3.modelo;

public class SorpresaDesfavorable extends Objeto{
    private float valor;

    public SorpresaDesfavorable() {
        this.valor = 0.25f;
    }

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo) {
        return unTipo.reaccionarASorpresaDesfavorable(movimientos);
    }
}
