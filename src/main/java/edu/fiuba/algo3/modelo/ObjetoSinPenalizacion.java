package edu.fiuba.algo3.modelo;

public class ObjetoSinPenalizacion extends Objeto{
    int penalizacion;

    public ObjetoSinPenalizacion() {
        this.penalizacion = 0;
    }

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Posicion posicionVehiculo ,Direccion unaDireccion, Movimiento unMovimiento) {
        movimientos += this.penalizacion;
        return movimientos;
    }
}
