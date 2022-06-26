package edu.fiuba.algo3.modelo;

public class ControlPolicial extends ObjetoCalle {
    public String getNombre() {return "controlPolicial";}
    public int reaccionar(int movimientos, TipoVehiculo unTipo, Movimiento unMovimiento){
        return unTipo.reaccionarAControlPolicial(movimientos, unMovimiento);
    }
}
