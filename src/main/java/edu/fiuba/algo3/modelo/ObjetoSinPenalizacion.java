package edu.fiuba.algo3.modelo;

public class ObjetoSinPenalizacion extends ObjetoCalle {
    int penalizacion;

    public ObjetoSinPenalizacion() {
        this.penalizacion = 0;
    }

    public String getNombre() {return "objetoSinPenalizacion";}
    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        movimientos += this.penalizacion;
        return movimientos;
    }
}
