package edu.fiuba.algo3.modelo;

public class Piquete extends ObjetoCalle {


    public Piquete() {
}
    public String getNombre() {return "piquete";}
    @Override
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento) {
        return unTipo.reaccionarAPiquete(movimientos, unMovimiento);
    }

}


