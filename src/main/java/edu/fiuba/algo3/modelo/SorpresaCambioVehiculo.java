package edu.fiuba.algo3.modelo;

public class SorpresaCambioVehiculo extends ObjetoCalle {
    public SorpresaCambioVehiculo(){
    }
    public String getNombre() {return "sorpresa";}

    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        return movimientos;
    }

    @Override
    public void verificarTipo(Vehiculo unVehiculo) {
        unVehiculo.cambioTipoDeVehiculo();
    }
}
