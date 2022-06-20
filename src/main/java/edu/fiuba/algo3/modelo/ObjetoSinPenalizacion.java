package edu.fiuba.algo3.modelo;

public class ObjetoSinPenalizacion extends Objeto{
    int penalizacion;

    public ObjetoSinPenalizacion() {
        this.penalizacion = 0;
    }

    @Override
    public int reaccionar(int cantidadDeMovimientos, TipoVehiculo unTipo) {
        cantidadDeMovimientos += this.penalizacion;
        return cantidadDeMovimientos;
    }
}
