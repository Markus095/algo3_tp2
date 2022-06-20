package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo extends Objeto{
    public SorpresaCambioVehiculo(){
    }

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Posicion posicionVehiculo ,Direccion unaDireccion, Movimiento unMovimiento) {
        return movimientos;
    }

    @Override
    public void verificarTipo(Vehiculo unVehiculo) {
        unVehiculo.cambioTipoDeVehiculo();
    }
}
