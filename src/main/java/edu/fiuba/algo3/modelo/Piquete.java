package edu.fiuba.algo3.modelo;

public class Piquete extends  Objeto {


    public Piquete() {
}

    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Posicion posicionVehiculo ,Direccion unaDireccion, Movimiento unMovimiento) {
        return unTipo.reaccionarAPiquete(movimientos, unMovimiento);
    }

}


