package edu.fiuba.algo3.modelo;

public class SorpresaFavorable extends Objeto {
    private float valor;

    public SorpresaFavorable() {
        this.valor = 0.8f;
    }

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Posicion posicionVehiculo ,Direccion unaDireccion, Movimiento unMovimiento) {
        return unTipo.reaccionarASorpresaFavorable(movimientos);
    }
}
